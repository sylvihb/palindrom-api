FROM openjdk:11
VOLUME /tmp
ADD   /target/palindrom-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Xmx750m", "-jar","/app.jar"]