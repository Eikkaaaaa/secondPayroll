# Use an official OpenJDK as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and POM files
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copy the source code
COPY src src

# Run Maven to build the project
RUN ./mvnw clean package -DskipTests

# Copy the built JAR file into the container
COPY target/secondPayroll-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port and H2 console port
EXPOSE 8080 9092

# Set environment variable for H2 file-based persistence
ENV SPRING_DATASOURCE_URL=jdbc:h2:file:/data/database;TRACE_LEVEL_FILE=3
ENV SPRING_H2_CONSOLE_ENABLED=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=create-drop

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]