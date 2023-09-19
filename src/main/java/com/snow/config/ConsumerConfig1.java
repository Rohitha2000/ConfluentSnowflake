package com.snow.config;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;


import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

@Configuration
public class ConsumerConfig1 {
	@Bean
	public ConsumerFactory<? super String, ? super KafkaAvroDeserializer> consumerBeanFactory() {
		Map<String, Object> consumerProps = new HashMap<>();
		consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-6ojv2.us-west4.gcp.confluent.cloud:9092");
		consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
		consumerProps.put("schema.registry.url", "https://psrc-lo3do.us-east-2.aws.confluent.cloud");
		consumerProps.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
		consumerProps.put(SaslConfigs.SASL_JAAS_CONFIG,
				"org.apache.kafka.common.security.plain.PlainLoginModule required username=\"P27CS6NEI2N5ITZY\" password=\"5PuApH28nH1zTCKCXVQ4EWdLSk+tYkMcOI3Sr4aDRN6uAEBVjFbayJYRLYp8f5sH\";");
		consumerProps.put("security.protocol", "SASL_SSL");
		consumerProps.put("basic.auth.credentials.source", "USER_INFO");
		consumerProps.put("schema.registry.basic.auth.user.info",
				"D6TKPTVGDBX677O2:Y/kCrZ3cOIGx2XxLaCaK/riYxb2bKsS80nW8HCYQorQYvw48AiIf0poFV6eDMs1e");
		consumerProps.put("ssl.endpoint.identification.algorithm", "https");

		// for ACK manual
		consumerProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		consumerProps.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, Boolean.valueOf(true));
		consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		return new DefaultKafkaConsumerFactory<>(consumerProps);
	}

	@Bean(name = "myAvroConsumerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, KafkaAvroDeserializer> myAvroConsumerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, KafkaAvroDeserializer> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
		factory.setConsumerFactory(consumerBeanFactory());
		return factory;
	}
}
