FROM maven:latest

ENV APP_HOME=/app/

COPY pom.xml $APP_HOME
COPY src $APP_HOME/src/
WORKDIR $APP_HOME

RUN mvn package -DskipTests
ENV JAR_FILE=target/achat-0.0.1-SNAPSHOT.jar

RUN mv ${JAR_FILE} /app.jar

EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]