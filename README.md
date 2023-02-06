Hello World sample shows how to deploy [SpringBoot](http://projects.spring.io/spring-boot/) RESTful web service application with [Docker](https://www.docker.com/) and with [Kubernetes](https://kubernetes.io/)

#### Prerequisite 

Installed:   
[Docker](https://www.docker.com/)   
[git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)   

Optional:   
[Docker-Compose](https://docs.docker.com/compose/install/)   
[Java 1.8 or 11.1](https://www.oracle.com/technetwork/java/javase/overview/index.html)   
[Maven 3.x](https://maven.apache.org/install.html)


#### Steps

##### Build Docker image
```
docker build -t="hello-world-java" .
```
Maven build will be executed during creation of the docker image.

>Note:if you run this command for first time it will take some time in order to download base image from [DockerHub](https://hub.docker.com/)

##### Run Docker Container
```
docker run -p 8080:8080 -it --rm hello-world-java
```

#####  Stop Docker Container:
```
docker stop `docker container ls | grep "hello-world-java:*" | awk '{ print $1 }'`
```
#### Test
Test application
````
curl -F 'file=@./matrix.csv' "localhost:8080/multiply"
response should be:
362880
````