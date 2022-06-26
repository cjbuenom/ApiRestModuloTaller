FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
USER root
RUN apk add --update curl && rm -rf /var/cache/apk/*
ENTRYPOINT ["java","-jar","/app.jar"]