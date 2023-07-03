FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} planilla-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/planilla-service-0.0.1-SNAPSHOT.jar"]