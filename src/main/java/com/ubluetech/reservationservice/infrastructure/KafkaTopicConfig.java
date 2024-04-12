package com.ubluetech.reservationservice.infrastructure;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
class KafkaTopicConfig {
    private final KafkaTopicProperties kafkaTopicProperties;

    @Bean
    public NewTopic reservationTopic() {
        return TopicBuilder.name(kafkaTopicProperties.getName())
                            .partitions(kafkaTopicProperties.getPartitions())
                            .replicas(kafkaTopicProperties.getReplicas())
                            .build();
    }
}
