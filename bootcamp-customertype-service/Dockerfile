FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customertype-service.jar
ENTRYPOINT ["java","-jar","/customertype-service.jar"]