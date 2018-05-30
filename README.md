# ACL security Module 

This module is a v1 of the package 7.2 "securisation et ACL" 

## Getting Started

The project is composed of two modules exposed on REST API

 - User ,role and privilege management functions 
 - LDAP connections and   security configure 
 - Swagger API to visualize the  REST API
The user schema is stored on a mongodb database
### Prerequisites
Java 8
Mongodb v3.4.13
Maven 4
Eclipse Oxygen (optional)
Tomcat 8.5

### Installing
##Step1: Run Mongodb
 run mongodb
 use test database
 the access configuration of mongodb and the used LDAP are in application.properties
##Step2: Install the backend
cd  to the directory where pom.xml
```
mvn clean install 
mvn spring-boot:run
```
##Step3: get the list of API 
 get the list of api using swagger
http://localhost:8080/swagger-ui.html



## Author

* **Rania Soussi** - *rania@armadillo.fr

