FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY ./target/zipkin-service-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 9411
CMD ["java", "-jar", "zipkin-service-1.0-SNAPSHOT.jar"]

