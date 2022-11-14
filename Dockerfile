FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/achat-1.0.jar test-docker.jar 
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar achat-1.0.jar"]