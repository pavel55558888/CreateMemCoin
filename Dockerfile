FROM openjdk:21-jdk-slim-bullseye
WORKDIR /app
COPY /target/CreateMemCoin-1.jar /app/createToken.jar
ENTRYPOINT ["java", "-jar", "createToken.jar"]