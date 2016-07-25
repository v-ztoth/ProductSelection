The project requires Java 8 and Maven.

To build the app and run all the tests please use this command from command line: <b>mvn clean install</b>


To run the project please use this command from command line: <b>mvn clean spring-boot:run</b>

Alternatively you can create a jar with this command: <b>mvn package</b>.
And you can run the jar.


The app is a Spring Boot app so you do not have to install Tomcat or any other web server.

It uses a H2 in memory DB to store the product and read the appropriate data from it.
When the app started Spring will create and populate the required PRODUCT table. You can check it: <b>localhost:8080/console</b>
Make sure you use this url as JDBC URL: jdbc:h2:mem:testdb

You can see the product selection page on this url: <b>http://localhost:8080/selectProduct</b>


I have used Spring Boot, Spring MVC, Spring Data with JPA, H2 DB technologies.
