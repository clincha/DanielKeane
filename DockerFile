FROM java:8-jdk-alpine
RUN mkdir /usr/app
COPY ./build/libs/DanielKeane-0.0.1.jar /usr/app
WORKDIR /usr/app
RUN sh -c "touch DanielKeane-0.0.1.jar"
ENTRYPOINT ["java", "-jar", "DanielKeane-0.0.1.jar"]