from amazoncorretto:17-alpine3.17-jdk
maintainer Ismael
copy /target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
entrypoint ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]