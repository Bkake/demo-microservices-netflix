FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY target/zipkin-service.jar zipkin-service.jar
EXPOSE 9411
CMD ["java", "-jar", "zipkin-service.jar"]

