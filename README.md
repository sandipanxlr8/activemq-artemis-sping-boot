# About

This is a sample project to connect to external ActiveMQ Artemis with Spring Boot.

Here i have created a listener and producer that will be connected to a queue, The producer can be triggered from the controller by hitting the POST /message endpoint with a string message in the request body.

Web console : http://localhost:8161/console

# configuration

Configurations related to ActiveMQ Artemis can be found in the application.properties file
