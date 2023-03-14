# School console app Spring

### Task 2.2<br/>


#### Build and run

To use this app you should install and launch Docker first.
Then execute:

1) mvn clean package
2) java -jar target/school-console-app-spring-0.0.1-SNAPSHOT.jar
3) docker compose up

or just
'docker compose -f docker-compose-no-test.yml up -d; docker attach school-console-app-spring-service-1'
