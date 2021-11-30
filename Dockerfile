FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

ENV JAR_FILE=bookings-microservice.jar

COPY target/$JAR_FILE .

EXPOSE 8080

ENTRYPOINT java -jar $JAR_FILE
