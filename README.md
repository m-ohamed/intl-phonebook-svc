# International Phonebook Service (Backend)

This is a simple application created using Spring Boot. It uses a SQLite database, and is able to categorize and validate phone numbers.

The repository currently contains a Dockerfile to dockerize this application, however, it is used with a Docker Compose file in the [main repository](https://github.com/m-ohamed/intl-phonebook).

This application runs on port 8080 and currently has only one REST API endpoint:

GET: /customer/ This endpoint returns the last of all customers in the database categorized and validated.
