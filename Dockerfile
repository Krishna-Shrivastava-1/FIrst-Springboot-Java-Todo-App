FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Maven files
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source
COPY src ./src

# Build JAR
RUN ./mvnw clean package -DskipTests

# Run JAR
EXPOSE $PORT
CMD ["java", "-jar", "target/*.jar"]
