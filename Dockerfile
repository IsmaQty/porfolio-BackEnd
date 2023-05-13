FROM amazoncorretto:17

MAINTAINER Ismael

COPY /target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]