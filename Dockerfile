FROM adoptopenjdk/maven-openjdk11
COPY target/paymentservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8095:8095
ENTRYPOINT ["java","-jar","app.jar"]