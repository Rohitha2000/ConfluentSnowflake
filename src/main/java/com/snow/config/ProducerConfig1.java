package com.snow.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.snow.schema.Customer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

@Configuration
@EnableKafka
public class ProducerConfig1 {

//	@Value("${spring.kafka.properties.bootstrap.servers}")
//	private String PROPS_NAME;

	@Bean
	public ProducerFactory<String, Customer> productFactory() {

		Map<String, Object> configProMap = new HashMap<>();
		configProMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-6ojv2.us-west4.gcp.confluent.cloud:9092");
		configProMap.put("schema.registry.url", "https://psrc-lo3do.us-east-2.aws.confluent.cloud");
		configProMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configProMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		configProMap.put("ssl.endpoint.identification.algorithm", "https"); 
		configProMap.put("sasl.mechanism", "PLAIN"); 
		configProMap.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"P27CS6NEI2N5ITZY\" password=\"5PuApH28nH1zTCKCXVQ4EWdLSk+tYkMcOI3Sr4aDRN6uAEBVjFbayJYRLYp8f5sH\";"); 
		configProMap.put("security.protocol", "SASL_SSL");
		configProMap.put("schema.registry.basic.auth.credentials.source", "USER_INFO");
		configProMap.put("schema.registry.basic.auth.user.info", "D6TKPTVGDBX677O2:Y/kCrZ3cOIGx2XxLaCaK/riYxb2bKsS80nW8HCYQorQYvw48AiIf0poFV6eDMs1e");
		configProMap.put("producer.type", "sync");         
		return new DefaultKafkaProducerFactory<>(configProMap);
	}

	@Bean(name="kafkaTemplate")
	public KafkaTemplate<String, Customer> kafkaTemplate() {
		return new KafkaTemplate<>(productFactory());
	}

}
