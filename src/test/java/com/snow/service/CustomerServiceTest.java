package com.snow.service;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.SettableListenableFuture;

import com.snow.model.CustomerModel;
import com.snow.repository.CustomerRepository;
import com.snow.schema.Customer;
import com.sun.xml.bind.v2.schemagen.xmlschema.Any;

@SpringBootTest
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository repo;
	
	 @Mock
	    private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@InjectMocks
	private CustomerService service;
	
	@Mock
	private Logger log= LoggerFactory.getLogger(CustomerService.class);
	
	 @Mock
	    private Acknowledgment acknowledgment;
	
	@Test
	public void listenTest() {
		ConsumerRecord<String, Customer> record = new ConsumerRecord<>(
                "customertopic",
                0,
                0L,
                "test-key",
                new Customer(123,2442, "John Doe", "Credit")
        );
		CustomerModel customer= new CustomerModel();
		Customer res=new Customer(123,2442, "John Doe", "Credit");
	 customer.setCustomeramount(res.getCustomeramount());
	 customer.setCustomerid(res.getCustomerid());
	 customer.setCustomername(res.getCustomername().toString());
	 customer.setPaymenttype(res.getPaymenttype().toString());
		when(repo.save(customer)).thenReturn(customer);
		doNothing().when(acknowledgment).acknowledge();
		service.listen(record, acknowledgment);
		Assertions.assertNotNull(res);
		
	}
	
	@Test
	public void testSend() throws Exception {
        // Create a sample customer
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerid(123);
        customerModel.setCustomername("John Doe");
        customerModel.setCustomeramount(1000);
        customerModel.setPaymenttype("Credit");
        Customer cust = new Customer(123,1000, "John Doe", "Credit");

        SettableListenableFuture<SendResult<String, Customer>> future = new SettableListenableFuture<>();
        future.set(new SendResult<>(new ProducerRecord<>("customertopic", "123", new Customer()), new RecordMetadata(null, 0, 0, 0, 0L, 0, 0)));

        when( kafkaTemplate.send("customertopic", String.valueOf(customerModel.getCustomerid()), cust)).thenReturn(future);

        service.send(customerModel);

        Assertions.assertEquals("123", future.get().getProducerRecord().key());

    }
	
	@Test
	public void sendExceptionTest() {
		 SettableListenableFuture<SendResult<String, Customer>> future = new SettableListenableFuture<>();
	        
	        // Simulate a failure by completing the future exceptionally
	        RuntimeException simulatedFailure = new RuntimeException("Simulated failure");
	        future.setException(simulatedFailure);
	        CustomerModel customerModel = new CustomerModel();
	        customerModel.setCustomerid(123);
	        customerModel.setCustomername("John Doe");
	        customerModel.setCustomeramount(1000);
	        customerModel.setPaymenttype("Credit");
	        Customer cust = new Customer(123,1000, "John Doe", "Credit");
	        when( kafkaTemplate.send("customertopic", String.valueOf(customerModel.getCustomerid()), cust)).thenReturn(future);

	        service.send(customerModel);
	}
	

}
