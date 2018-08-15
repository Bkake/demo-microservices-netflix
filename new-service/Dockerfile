FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY ./target/new-service-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 8383
CMD ["java", "-jar", "new-service-1.0-SNAPSHOT.jar"]

