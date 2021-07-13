FROM openjdk:16-jdk-alpine
RUN addgroup -S demogrp && adduser -S demousr -G demogrp
USER demousr:demogrp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]