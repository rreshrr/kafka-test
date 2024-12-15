package ru.thomaskohouse.kafkatemplate.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class KafkaHelper {
    private final KafkaSender kafkaSender;

    public void sendMessage(String msg, String topicName) {
        log.info("Sending to {} msg [{}]", topicName, msg);
        kafkaSender.sendMessage(msg, topicName);
    }

    public void sendMessage(String msg, String topicName, String partition) {
        log.info("Sending to {}/{} msg [{}]", topicName, partition, msg);
        kafkaSender.sendMessage(msg, topicName, partition);
    }
}
