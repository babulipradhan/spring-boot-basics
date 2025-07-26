# spring-boot-demo
This repo contains POC for basis concepts of spring and spring-boot

**kafka-spring-boot:**
- Starting Zookeeper :
Kafka relies on Zookeeper for managing and coordinating the Kafka brokers. Before starting Kafka, you need to start Zookeeper.
  Open a command prompt and navigate to the Kafka binary directory (e.g., D:\Softwares\kafka_2.13-3.9.1\bin\).
  Run the following command
- Starting Zookeeper:
  
  zookeeper-server-start.bat ..\config\zookeeper.properties

- Starting the Kafka Server (2 brokers):
  
  a) kafka-server-start.bat ..\config\server.properties
  
  b) kafka-server-start.bat ..\config\server-1.properties
- Creating a Kafka Topic
  
  kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 2

- Deleting Kafka Topic
  
  kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic my-topic

- Producing Messages to a Kafka Topic
  
  Hit below endpoint from postman or browser
  
  http://localhost:8080/v1/api/kafka/message/10

**spring-boot-basics:**


**System requirements**  
- JDK 17      
- Maven      
- Kafka 2.13  