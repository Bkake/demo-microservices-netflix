FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY ./target/gateway-service-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
EXPOSE 8762
CMD ["java", "-jar", "gateway-service-1.0-SNAPSHOT.jar"]

