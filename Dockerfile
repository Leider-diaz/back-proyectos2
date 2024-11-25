# Example using MS Build of OpenJDK image directly
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN sudo ./mvnw package -DskipTests
FROM openjdk:17-jdk-slim
#FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

WORKDIR /app

#COPY target/sistemacompras.jar app.jar
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8094

# Continue with your application deployment
#RUN mkdir /opt/app
#COPY japp.jar /opt/app
CMD ["java", "-jar", "app.jar"]
#CMD ["java", "-jar", "/opt/app/japp.jar"]
