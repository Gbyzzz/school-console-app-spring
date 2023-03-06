#FROM maven:3.8.3-openjdk-17
#
#WORKDIR /
#COPY . .
RUN mvn clean package -DskipTests
ENTRYPOINT ["java", "-jar", "target/school-console-app-spring-0.0.1-SNAPSHOT.jar"]

#CMD mvn spring-boot:run