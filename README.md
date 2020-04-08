# Movies
API Rest returns a movies list, with diferents roles: admin for update, add, delete and view all movies
, user registered for rent movies and watch all catalog.

## Test
You are available to test with Postman, at `/src/main/resources/requests` just for import in postman.

## Functions
* Movies catalog
* Update movie
* Delete a movie
* Add a movie
* Filter by tile movie catalog


### Authentication
Is a POST function, you can access at:
`http://localhost:8080/login`
#### Input
```
{
    "username":"randy.adonis@applaudostudio.com",
    "password":"DemoPassword"
}
```
#### Output
```
{"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIi"}
```


## Resources
* Java 8
* IntelliJ IDEA Ultimate 2018.2
* Maven 4.0.0
* Spring Boot 2.2.4
* PostgresSQL  9.5

## Install
* Create a BDD 
* Import SQL script from folder: /src/main/resources/database
* Add project to IntelliJ
* Run as SpringBoot Application
