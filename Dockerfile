FROM openjdk:8-jdk-alpine
ADD ./pioneer-store-member/target/pioneer-store-member.jar ./pioneer-store-member.jar
ENTRYPOINT ["java", "-jar","./pioneer-store-member.jar"]