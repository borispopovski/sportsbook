# Sportsbook API quide

Spotrsbook API is java service as a Sping boot app which takes JSON string message with objects.

There are 3 endpoints (GET, POST, PUT):
* /sports/get/{id} (get sports book)
* /sports/create	 (create sportsbook)
* /sports/modify   (update sportsbook)

There are Dto classes for receiving json message and easier implementation.
Objects fill directly when it will receive json message.
Objects stored in mariadb.
There is a configuration for mariadb in application.properties.

I use JPA, actually Hibernate for comunucation with a database.

I use Helper class for converting objects.
* dto -> entity
* entity -> dto

Access to API through a Swagger or Postman collection

* Swagger url: http://localhost:8080/swagger-ui/index.html/
* There is a postman collection in the project. It should import in a Postman.
