FROM openjdk:8u292-jdk-slim
COPY ./life-blog-0.0.1-SNAPSHOT.jar /webdev/app.jar
RUN mkdir -p /webdev/logs
EXPOSE 2716
CMD nohup java -jar /webdev/app.jar