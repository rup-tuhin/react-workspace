# Read Me First
Demo project for Autocomplete.

GET  /suggestions - Will list some sample suggestions.

POST /suggestions - Will add the item in the list.

# Getting Started
- Docker build 

1. docker build -t spring/autocomplete:1.0 .
2. docker run -p 8080:8080 spring/autocomplete:1.0
3. verify - curl -X GET "http://localhost:8080/suggestions"

 - in local with JAVA installed

    1. run the maven build - mvn clean install
    2. %CLASSPATH%\java -jar autocomplete-0.0.1-SNAPSHOT.jar

Note: set your classpath via

set CLASSPATH=%CLASSPATH%;C:\Users\USER\.jdks\openjdk-16.0.1\bin;

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

