package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MessageProducer;

@RestController
public class MessageContoller {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    MessageProducer messageProducer;

    @Value("${jms.queue-name}")
    private String queueName;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }

    @PostMapping("/producer/message")
    public void sendMessageThroughProducer(@RequestBody String message) {
        messageProducer.sendMessage(message);
    }
}
