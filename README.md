# microservices

To build all the sub-projects, run: 
`./gradlew build`

To run all the sub-projects, run: 
`java -jar microservices/product-composite-service/build/libs/*.jar & java -jar microservices/product-service/build/libs/*.jar & java -jar microservices/recommendation-service/build/libs/*.jar & java -jar microservices/review-service/build/libs/*.jar`
