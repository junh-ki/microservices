# microservices

To build all the sub-projects, run:  
`./gradlew build`

To run tests only:  
`./gradlew test`

To run all the sub-projects, run:  
`java -jar microservices/product-composite-service/build/libs/*.jar & java -jar microservices/product-service/build/libs/*.jar & java -jar microservices/recommendation-service/build/libs/*.jar & java -jar microservices/review-service/build/libs/*.jar`

To build and start the docker-compose system landscape:  
`./gradlew build && docker-compose build && docker-compose up -d`  
Make sure that Docker Daemon is up and running, otherwise some tests will fail.  

Bring down the Docker Compose landscape:  
`docker-compose down --volumes`  

In case Docker Daemon is not running:  
`sudo ln -s ~$USER/.rd/docker.sock /var/run/docker.sock`

Getting into a docker container:  
`docker exec -it abcd /bin/bash`  

To change docker-compose.yml file:  
`export COMPOSE_FILE=docker-compose-partitions.yml`  
`docker-compose build && docker-compose up -d`  
`docker-compose down --volumes`  
`unset COMPOSE_FILE`  

When running RabbitMQ with partitions, replace the healthcheck argument, `status`, with `cluster_status`.  
Otherwise, the RabbitMQ container will keep getting killed. -> I don't know why yet.  

See the logs in a container:  
`docker logs {{container_name}} -f`  

To see a list of topics in the Kafka container:  
`docker-compose exec kafka /opt/kafka/bin/kafka-topics.sh --zookeeper zookeeper --list`

To see the partitions in a specific topic, for example, the `products` topic:  
`docker-compose exec kafka /opt/kafka/bin/kafka-topics.sh --describe --zookeeper zookeeper --topic products`

To see all the messages in a specific topic, for example, the `products` topic:  
`docker-compose exec kafka /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic products --from-beginning --timeout-ms 1000`

To see all the messages in a specific parition, for example, parition 1 in the `products` topic:  
`docker-compose exec kafka /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic products --from-beginning --timeout-ms 1000 --partition 1`
