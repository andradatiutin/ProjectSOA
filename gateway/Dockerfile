#FROM alpine:latest
# add dockerize tool -------------------
#RUN apk add --no-cache openssl
#ENV DOCKERIZE_VERSION v0.6.1
#RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
#    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
#    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

# build the jar file with maven
FROM maven:3.8.4-openjdk-17 AS build
RUN mkdir -p /gateway
WORKDIR /gateway
COPY pom.xml /gateway
COPY src /gateway/src
RUN mvn -f pom.xml clean package

# use the jar file to compile project
FROM openjdk:17-jdk-slim
RUN mkdir -p /gateway
WORKDIR /gateway
COPY --from=build gateway/target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar
EXPOSE 9099 9090 9092 9093
ENTRYPOINT ["java","-jar","gateway-0.0.1-SNAPSHOT.jar"]

#RUN apt-get update
#RUN apt-get install -y curl
#RUN apt-get install -y telnet

# we will use openjdk 8 with alpine as it is a very small linux distro
#FROM adoptopenjdk/openjdk16
# copy the packaged jar file into our docker image
#COPY target/software_system_backend-0.0.1-SNAPSHOT.jar software_system_backend-0.0.1-SNAPSHOT.jar
# set the startup command to execute the jar
#CMD ["java", "-jar", "software_system_backend-0.0.1-SNAPSHOT.jar"]
