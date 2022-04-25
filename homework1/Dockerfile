FROM openjdk:11-jre-slim-buster
MAINTAINER Stepan Kashintsev <>

ENV JAVA_MEM="-Xmx128M"
ENV JAVA_EXT=""

ADD build/libs/*-all.jar app.jar
CMD java $JAVA_MEM $JAVA_EXT -jar /app.jar
EXPOSE 8000