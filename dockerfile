FROM amazoncorretto:11
add /target/ms-rickandmorty-0.0.1-SNAPSHOT.jar ms-rickandmorty-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ms-rickandmorty-0.0.1-SNAPSHOT.jar"]