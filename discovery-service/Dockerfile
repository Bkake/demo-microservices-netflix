FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY ./target/discovery-service-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 8761
CMD ["java", "-jar", "discovery-service-1.0-SNAPSHOT.jar"]

