FROM java:8-jdk-alpine
RUN mkdir /app
COPY DanielKeane-0.0.1.jar /app
WORKDIR /app
ENTRYPOINT ["java", "-jar", "DanielKeane-0.0.1.jar"]