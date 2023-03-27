package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
  // @JmsListener(destination = "${jms.topic-name}", containerFactory =
  // "jmsListenerContainerFactory")
  // public void onMessage(String message) {
  // System.out.println("Received message inside onMessage: " + message);
  // System.out.println("Message processed inside onMessage: " + message);
  // }

  @JmsListener(destination = "${jms.topic-name}", containerFactory = "jmsListenerTopicContainerFactory", subscription = "mySharedSubscription")
  public void onMessage(String message) throws InterruptedException {
    System.out.println("Message started processing inside onMessage - B: " + message);
    TimeUnit.SECONDS.sleep(10);
    System.out.println("Message processed inside onMessage - B: " + message);
  }
}
