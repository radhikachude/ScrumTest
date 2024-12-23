FROM openjdk:21-jdk
WORKDIR /app
COPY target/scrum.team-0.0.1-SNAPSHOT.jar scrum.team.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "scrum.team.jar"]