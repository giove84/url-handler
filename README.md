# url-handler

Application architecture

This web application has been developed using Spring Boot and Spring Web and built with Maven.
It can be launched using the command "mvn spring-boot:run".
The main class is the @SpringBootApplication annotated URLHandlerApplication.java, which runs the application and shows the home page.

The web application is layered in 3 levels: a web layer, containing views and controller; a business layer, containing the business logic; a model layer, containing a repository for accessing the database.
There is a controller (URLShortenerController) that handles the requests coming from the home page for creating a short URL. It then calls the service layer invoking the URLShortenerService class, which implements the logic for shortening the URL and for persisting the data on the database.
Once the URL is created, the controller redirects to the "result" view displaying the shortened URL and a link to the original one.
Here the user makes a request for redirecting to the original URL. Again, the URLShortenerController will handle the request and will call the business layer, where the URLShortenerService will decode the shortened URL, retrieve it from the database and returns the original one to the controller, that finally redirect to the original URL.
The persistence layer uses a JPA repository.

The database used is the H2 database, an in-memory database embedded in Spring Boot. The console for displaying the tables is available at http://localhost:8080/h2-console

The application contains a Dockerfile that can be used for creating a Docker image.
The command for building a Docker image for this web app is: docker build -t url-handler-app .
