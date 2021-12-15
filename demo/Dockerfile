FROM openjdk:11.0.9.1-jre-buster
ARG MYSQL_HOST
RUN rm /etc/localtime && ln -s /usr/share/zoneinfo/America/Bogota /etc/localtime && echo "America/Bogota" > /etc/timezone
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
ENV MYSQL_HOST=127.0.0.1
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

# Create the docker image
# docker build -t demo .
# Run the container
# docker run -d -p 8080:8080 --name demo -e MYSQL_HOST=$MYSQL_HOST demo:latest
# docker run -it -p 8080:8080 --name demo -e MYSQL_HOST=$MYSQL_HOST demo:latest