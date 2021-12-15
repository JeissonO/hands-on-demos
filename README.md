# hands-on-demos

Demos and lesson labs

## Launch initial stack

You can run a initial stack using docker and docker compose. 

With tha basic stack you going to deploy:
- mysql database
	- For this database the default values are:
	- user: root
	- pass: example

- mysql admin interface

- sonarqube
	- for sonarqube the dafault inital values are:
	- user: admin
	- pass: admin
> **Note**: Sonar is running with the default H2 database. If you want to use a persisted database, you have to include in this stack the required configuration. 
 

### How to use it:

Deploy the stack with the following comand

```shell 
 docker-compose up -d
 # or
 docker-compose -p dev up -d
```

Remove / Destroy the stack

```shell 
 docker-compose down
 # or 
 docker-compose -p dev down
```

Start / Stop the stack

```shell 
 docker-compose start
 docker-compose stop
 # or 
 docker-compose -p dev start
 docker-compose -p dev stop
```

## Execute Sonar 

### Java

1. If you are using `mvn` and have been using the defaul stack that is in this repo. only need to execute or onclude the follofing command foir each java app.

```shell
mvn sonar:sonar
```
> ***Note:*** If you are using a diferent sonar server or sonar cloud you nedd to configure each project accordingly with your server or account. 