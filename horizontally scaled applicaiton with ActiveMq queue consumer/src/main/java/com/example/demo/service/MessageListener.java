package com.example.demo.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
  @JmsListener(destination = "${jms.queue-name}", containerFactory = "jmsListenerContainerFactory")
  public void onMessage(String message) {
    System.out.println("Received message inside onMessage: " + message);
    System.out.println("Message processed inside onMessage: " + message);
  }

  @JmsListener(destination = "${jms.queue-name}")
  public void receiveMessage(String message) throws InterruptedException {
    System.out.println("Received message inside receiveMessage: " + message);
    Thread.sleep(10000); // simulate processing time
    System.out.println("Message processed inside receiveMessage: " + message);
  }
}
