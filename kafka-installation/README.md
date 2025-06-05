Employee Service – Kafka Setup Guide (Local, Windows)

This guide documents how to set up and interact with Apache Kafka locally (on Windows) for the employee-service microservice in a Spring Boot-based microservices architecture.

--------------------------------------------------
Prerequisites:

- Java installed and configured in your system PATH
- Apache Kafka downloaded and extracted
- Kafka folder contains: bin\windows\ and config\

--------------------------------------------------
Kafka Startup Instructions:

1. Start Zookeeper:
   bin\windows\zookeeper-server-start.bat config\zookeeper.properties

2. Start Kafka Broker:
   bin\windows\kafka-server-start.bat config\server.properties

--------------------------------------------------
Kafka Topic Management:

- Create a topic:
  bin\windows\kafka-topics.bat ^
    --bootstrap-server localhost:9092 ^
    --create --topic employee-topic ^
    --partitions 3 ^
    --replication-factor 1

- List all topics:
  bin\windows\kafka-topics.bat ^
    --bootstrap-server localhost:9092 ^
    --list

- Describe a topic:
  bin\windows\kafka-topics.bat ^
    --bootstrap-server localhost:9092 ^
    --describe --topic employee-topic

--------------------------------------------------
Kafka Messaging:

- Produce messages (basic):
  bin\windows\kafka-console-producer.bat ^
    --broker-list localhost:9092 ^
    --topic employee-topic

- Produce messages with key support:
  bin\windows\kafka-console-producer.bat ^
    --broker-list localhost:9092 ^
    --topic employee-topic ^
    --property "parse.key=true" ^
    --property "key.separator=:"

- Consume messages (basic):
  bin\windows\kafka-console-consumer.bat ^
    --bootstrap-server localhost:9092 ^
    --topic employee-topic ^
    --from-beginning

- Consume messages with key and value:
  bin\windows\kafka-console-consumer.bat ^
    --bootstrap-server localhost:9092 ^
    --topic employee-topic ^
    --from-beginning ^
    --property print.key=true ^
    --property print.value=true

--------------------------------------------------
Clean Up Kafka Logs (Optional):

To reset Kafka/Zookeeper logs and clean local state:

1. Navigate to Kafka log directory:
   cd C:\tmp\

2. Delete logs using PowerShell:
   Remove-Item -Recurse -Force .\kafka-logs\
   Remove-Item -Recurse -Force .\zookeeper\



--------------------------------------------------
Project Context:

This Kafka setup is used by the employee-service microservice, which is part of a modular microservices architecture. Each service can publish/consume events on topics like employee-topic.

--------------------------------------------------
Useful Links:

- Apache Kafka: https://kafka.apache.org/documentation/
- Kafka CLI Tools: https://kafka.apache.org/documentation/#basic_ops_cli
- Spring for Apache Kafka: https://docs.spring.io/spring-kafka/

Happy Coding!
