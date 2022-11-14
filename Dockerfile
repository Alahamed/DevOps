FROM openjdk:8-alpine
ARG JAR_FILE=target/achat.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]