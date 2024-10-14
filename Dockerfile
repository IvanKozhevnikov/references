FROM eclipse-temurin:21-jdk

EXPOSE 8080

RUN mkdir references

WORKDIR references

COPY . .

RUN mvn package

CMD ["mvn", "liquibase:update", "-Pdocker"]

CMD ["java", "-jar", "target/references-1.0-SNAPSHOT.jar"]