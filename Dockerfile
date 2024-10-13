FROM maven:3.6.3-openjdk:21 AS build
RUN mkdir references
WORKDIR references
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/references-1.0-SNAPSHOT.jar"]