# Use an official OpenJDK image as base
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
