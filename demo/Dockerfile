FROM openjdk:11.0.9.1-jre-buster
ARG MYSQL_HOST
ARG MYSQL_DATABASE
ARG MYSQL_USER
ARG MYSQL_PASSWORD
RUN rm /etc/localtime && ln -s /usr/share/zoneinfo/America/Bogota /etc/localtime && echo "America/Bogota" > /etc/timezone
COPY target/*-0.0.1-SNAPSHOT.jar app.jar
ENV MYSQL_HOST="$MYSQL_HOST"
ENV MYSQL_DATABASE="$MYSQL_DATABASE"
ENV MYSQL_USER="$MYSQL_USER"
ENV MYSQL_PASSWORD="$MYSQL_PASSWORD"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

# Create the docker image
# docker build -t demo .
# Run the container
#
# docker run -d -p 8080:8080 --name demo -e MYSQL_HOST=$MYSQL_HOST -e MYSQL_DATABASE=$MYSQL_DATABASE -e MYSQL_USER=$MYSQL_USER -e MYSQL_PASSWORD=$MYSQL_PASSWORD demo:latest
# or
# docker run -d -p 8080:8080 --name demo -e MYSQL_HOST=192.168.0.10 -e MYSQL_DATABASE=school -e MYSQL_USER=demo-user -e MYSQL_PASSWORD="Nbmna.?ha1213" demo:latest
# in interactive terminal
# docker run -it -p 8080:8080 --name demo -e MYSQL_HOST=$MYSQL_HOST -e MYSQL_DATABASE=$MYSQL_DATABASE -e MYSQL_USER=$MYSQL_USER -e MYSQL_PASSWORD=$MYSQL_PASSWORD demo:latest
