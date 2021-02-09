FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./pioneer-store-member/target/pioneer-store-member.jar ./pioneer-store-member.jar
ENTRYPOINT ["java", "-jar","./pioneer-store-member.jar"]