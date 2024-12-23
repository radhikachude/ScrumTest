FROM openjdk:21-jdk
WORKDIR /app
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "EurekaServer.jar"]