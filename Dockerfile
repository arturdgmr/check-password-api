FROM adoptopenjdk/openjdk11:alpine

MAINTAINER Artur Rodrigues

COPY /build/libs/check-password-api-0.0.1.jar /var/www/spring-app.jar

WORKDIR /var/www

ENTRYPOINT ["java", "-jar", "spring-app.jar"]



