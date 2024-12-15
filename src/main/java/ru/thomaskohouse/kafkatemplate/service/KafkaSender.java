package ru.thomaskohouse.kafkatemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    public void sendMessage(String message, String topic, String partition) {
        kafkaTemplate.send(topic, partition, message);
    }
}