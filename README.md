<h1 align="center"> Welcome to Foro-Hub </h1>
<h3 align="center"> REST API responsible for performing CRUD operations for the fictional social network Foro-Hub </h3>

![Badge in Development](https://img.shields.io/badge/Version-1.0-green) ![Last Update](https://img.shields.io/badge/Last%20update-14%2F07%2F2024-blue)

# Index

1. [Project Description](#project-description)
2. [Tools Used](#tools-used)

## Project Description

This API is the final project of the "Back-End Developer with Spring" formation from Alura Latam, designed to demonstrate the knowledge acquired over 6 months of training. The project 
consists of an API that implements RESTful principles in its development and is responsible for performing CRUD operations on entities in a fictional social network. Foro-Hub also 
applies technologies such as Spring Security and validations through JWT tokens to verify user validity.

### Features  

* Ability to receive POST requests to create new topics (posts) and save them in the database.
* Ability to receive PUT requests to update existing topics with different information.
* Ability to display topics (both all together and individually) in the database by receiving GET requests.
* Ability to permanently delete an existing topic through DELETE requests.
* Ensure the privacy of information within the database through Spring Security methods as well as JWT Token Validation and user Authorization.


## Tools Used

* Spring Security
* Spring Boot
* JSON Web Token standard
* PostgreSQL
* Flyway Migration
* pgAdmin 4 (testing purposes)
* Insomnia (testing purposes)

