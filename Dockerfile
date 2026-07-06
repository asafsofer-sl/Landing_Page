# Step 1: Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the compiled jar from the target folder into the container
# Note: Maven names the jar based on artifactId and version in pom.xml
COPY target/landing-page-customizer-1.0-SNAPSHOT.jar app.jar

# Step 4: Expose the port Spring Boot runs on
EXPOSE 8080

# Step 5: Run the web application
ENTRYPOINT ["java", "-jar", "app.jar"]
