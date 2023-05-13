from amazoncorretto:17.0.7
maintainer Ismael
copy /target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
entrypoint ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]