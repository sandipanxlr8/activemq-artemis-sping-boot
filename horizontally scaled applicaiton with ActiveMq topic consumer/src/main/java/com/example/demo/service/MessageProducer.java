package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
  @Autowired
  private JmsTemplate jmsTemplate;

  @Value("${jms.topic-name}")
  private String topicName;

  public void sendMessage(String message) {
    System.out.println("Sending message: " + message);
    jmsTemplate.convertAndSend(topicName, message);
  }
}
