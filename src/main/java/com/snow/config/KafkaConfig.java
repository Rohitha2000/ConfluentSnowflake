package com.snow.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.snow.model.CustomerModel;


@Configuration
public class KafkaConfig {

	@Bean
	public ConsumerFactory<String, CustomerModel> consumerFactory(KafkaProperties kafkaProperties) {
		return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, CustomerModel>> 
		kafkaListenerContainerFactory( KafkaProperties kafkaProperties) {

		ConcurrentKafkaListenerContainerFactory<String, CustomerModel> factory = 
				new ConcurrentKafkaListenerContainerFactory<String, CustomerModel>();
		factory.setConsumerFactory(consumerFactory(kafkaProperties));

		return factory;
	}

}
