package com.karnikamit.school_admission_system.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.topic.name:admission_requests}")
    private String kafkaTopicName;

    // Explicit defining is not required!
    
//    @Bean
//    public KafkaAdmin admin() {
//        System.out.println("Configuring KafkaAdmin with bootstrap servers: " + bootstrapServers);
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        return new KafkaAdmin(configs);
//    }

    @Bean
    public NewTopic admissionTopic() {
        System.out.println("Building Kafka admission topic with name: " + kafkaTopicName);
        return TopicBuilder.name(kafkaTopicName)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
