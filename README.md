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
