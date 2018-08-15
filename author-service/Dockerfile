FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY ./target/author-service-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 8282
CMD ["java", "-jar", "author-service-1.0-SNAPSHOT.jar"]

