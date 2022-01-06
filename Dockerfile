FROM maven:3.8.4-jdk-11 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY . /workspace
RUN mvn clean package

FROM openjdk:11-jre-slim
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]