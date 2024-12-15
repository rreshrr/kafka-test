package ru.thomaskohouse.kafkatemplate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.thomaskohouse.kafkatemplate.service.KafkaHelper;

@RestController
@AllArgsConstructor
public class MessageController {

    private final KafkaHelper kafkaHelper;

    @PostMapping("/topic/{topicName}")
    public void sendMessage(@RequestBody String msg, @PathVariable String topicName) {
        kafkaHelper.sendMessage(msg, topicName);
    }

    @PostMapping("/topic/{topicName}/{partition}")
    public void sendMessage(@RequestBody String msg, @PathVariable String topicName, @PathVariable String partition) {
        kafkaHelper.sendMessage(msg, topicName, partition);
    }

}
