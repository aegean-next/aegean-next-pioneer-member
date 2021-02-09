FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD pioneer-store-member.jar pioneer-store-member.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]