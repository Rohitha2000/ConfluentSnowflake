package com.snow.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.snow.model.CustomerModel;
import com.snow.repository.CustomerRepository;
import com.snow.schema.Customer;


@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	    @Autowired
	    private KafkaTemplate<String, Customer> kafkaTemplate;
	    
	    
        // Sending the data to Kafka Topic 
	    public void send(CustomerModel customer){
	    	
	    	Customer cust= new Customer();
	    	cust.setCustomerid(customer.getCustomerid());
	    	cust.setCustomername(customer.getCustomername());
	    	cust.setCustomeramount(customer.getCustomeramount());
	    	cust.setPaymenttype(customer.getPaymenttype());
	    	
	    	log.info("*** entered service call {}", customer);
	       ListenableFuture<SendResult<String,Customer>> future= 
	    		   kafkaTemplate.send("customertopic", String.valueOf(cust.getCustomerid()), cust);
	       future.addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {
	           @Override
	           public void onFailure(Throwable ex) {
	        	   log.info("Message failed to produce");
	           }

	           @Override
	           public void onSuccess(SendResult<String, Customer> result) {
	        	   log.info("AVRO message successfully produced to Kafka Topic");
	           }
	       });

	    }
	    
	    /*Method Implementation to Consume the data by Listening to Kafka topic and
	     *  Saving the data to Snowflake database
	     */
	      
	    @KafkaListener(topics = "customertopic", groupId = "consumer-group", 
				containerFactory = "myAvroConsumerFactory")
		public void listen(ConsumerRecord<String, Customer> record, Acknowledgment ack) {
			log.info("************** Consumer started reading topic Customertopic based on AVRO schema specifications with topicname - partition - offset -{} -{} - {} ", 
					record.topic(), record.partition(), record.offset());
			String key = record.key();
			Customer response = record.value();
			 ack.acknowledge();
			log.info("Consumed the customer information of key : " + key + " value : " + response.toString());
			CustomerModel customer= new CustomerModel();
			customer.setCustomerid(response.getCustomerid());
			customer.setCustomername(response.getCustomername().toString());
			customer.setCustomeramount(response.getCustomeramount());
			customer.setPaymenttype(response.getPaymenttype().toString());
			
			log.info("Acknowledge --- {} -- {} ", record.partition(), record.offset());
			log.info("AVRO data successfully consumed {}", customer.toString());
			
			CustomerModel result= customerRepo.save(customer);
			
			
			if((customer.toString()).equals(result.toString())) {
			log.info("saved the customer information to the Snowflake Database");
			}
			else if(customerRepo.findById(customer.getCustomerid()) == null){
				log.info("Failed to save the customer information to Snowflake Database");
			}
		}
	    


}
