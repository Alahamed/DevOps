FROM openjdk:8-alpine
ADD target/achat-0.0.1.jar achat-0.0.1.jar
EXPOSE 8089
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar achat-0.0.1.jar"]