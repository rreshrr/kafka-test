package ru.thomaskohouse.kafkatemplate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-1", groupId = "group1")
    void listener(String data) {
        log.info("Received message [{}] in group1", data);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2", groupId = "group1", topicPartitions = @TopicPartition(topic = "topic-2", partitions = "2"))
    void listener2(String data) {
        log.info("Received message [{}] in group1, topic-2/2", data);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2", groupId = "group1", topicPartitions = @TopicPartition(topic = "topic-2", partitions = "1"))
    void listener3(String data) {
        log.info("Received message [{}] in group1, topic-2/1", data);
    }
}