FROM openjdk:11-jre-slim
COPY build/libs/DanielKeane-live.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]