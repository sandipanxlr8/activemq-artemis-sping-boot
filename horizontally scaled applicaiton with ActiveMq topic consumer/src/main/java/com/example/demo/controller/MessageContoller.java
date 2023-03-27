package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageContoller {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.topic-name}")
    private String topicName;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend(topicName, message);
    }
}
