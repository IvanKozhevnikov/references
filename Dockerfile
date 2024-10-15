FROM  maven:3.9.9-eclipse-temurin-21

EXPOSE 8080

RUN mkdir references

WORKDIR references

COPY . .

RUN mvn package -Dmaven.test.skip=true

CMD ["mvn", "liquibase:update", "-Pdocker"]

CMD ["java", "-jar", "target/references-1.0-SNAPSHOT.jar"]