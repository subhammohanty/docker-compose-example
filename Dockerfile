FROM openjdk:17
WORKDIR /myApp
COPY ./target/transaction-service.jar /myApp
EXPOSE 8181
CMD ["java", "-jar", "transaction-service.jar"]