http://localhost:8087/



Database configuration

database Postgresql

username=postgres

password=postgres

url=jdbc:postgresql://localhost:5432/test



request in Postman

request type - GET

http://localhost:8087/author/info/short/1

response

{ "id": 1, "firstName": "Leonid", "lastName": "Dubravsky", "age": 39, "books": [ "The Alchemist" ] }