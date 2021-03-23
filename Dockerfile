FROM openjdk:latest
COPY ./target/group.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group.jar", "db:3306"]