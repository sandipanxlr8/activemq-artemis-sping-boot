package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
  @Autowired
  private JmsTemplate jmsTemplate;

  @Value("${jms.queue-name}")
  private String queueName;

  public void sendMessage(String message) {
    System.out.println("Sending message: " + message);
    jmsTemplate.convertAndSend(queueName, message);
  }
}
