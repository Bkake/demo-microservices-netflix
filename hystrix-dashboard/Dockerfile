FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY target/hystrix-dashboard.jar hystrix-dashboard.jar
EXPOSE 8763
CMD ["java", "-jar", "hystrix-dashboard.jar"]
