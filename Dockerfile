FROM openjdk:17
COPY target/simpleApp-0.0.1-SNAPSHOT.jar /app/simpleApp.jar
CMD ["java","-jar", "/app/simpleApp.jar"]