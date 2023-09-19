# ConfluentSnowflake
This is a POC Project for Integrating Confluent Kafka with Snowflake Database.
We have no of customer details to be stored in Database. So, we are sending the customer data to Confluent Kafka with AVRO Schema by Producer.
Now, we have Listener method which listens to the kafka topic and when data is available, it is consumed by Kafka Listener and we are saving the received information to Snowflake Database
We are defining Snowflake credentials in the configuration to establish the connection with Snowflake database to perform operations on Database.



