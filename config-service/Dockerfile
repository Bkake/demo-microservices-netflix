FROM openjdk:8-jre-alpine
MAINTAINER Bangaly KAKE <bangaly.kake@gmail.com>
COPY target/config-service.jar config-service.jar
EXPOSE 8888
CMD ["java", "-jar", "config-service.jar"]
#HEALTHCHECK --interval=5s --timeout=3s --retries=3 CMD curl -v  http://localhost:8888/health 2>&1 | grep UP

