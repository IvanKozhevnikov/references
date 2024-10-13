FROM eclipse-temurin:21-jdk
RUN mkdir references
WORKDIR references
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/references-1.0-SNAPSHOT.jar"]