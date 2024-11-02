FROM openjdk:17-jdk-slim

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw clean package -DskipTests

COPY target/secondPayroll-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080 9092

ENV SPRING_DATASOURCE_URL=jdbc:h2:file:/data/database;
ENV SPRING_H2_CONSOLE_ENABLED=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=create-drop

ENV SPRING_WEB_CORS_ALLOW_CREDENTIALS=true
ENV SPRING_WEB_CORS_ALLOWED_ORIGINS=http://localhost:5173

ENTRYPOINT ["java", "-jar", "app.jar"]