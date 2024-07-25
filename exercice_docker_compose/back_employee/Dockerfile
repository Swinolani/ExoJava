FROM maven AS builder

COPY pom.xml .
RUN mvn dependancy:go-offline

COPY src ./src
RUN mvn package -DskipTests


FROM openjdk:17-jdk

WORKDIR /app

COPY target/back_employee-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
