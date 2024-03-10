FROM openjdk:17
EXPOSE 9000
ADD target/oauth2-authorization-server.jar oauth2-authorization-server.jar
ENTRYPOINT ["java","-jar","/oauth2-authorization-server.jar"]