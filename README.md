The project requires Java 8 and Maven.

To build the app and run all the tests please use this command from command line: mvn clean install


To run the project please use this command from command line: mvn clean spring-boot:run

Alternatively you can create a jar with this command: mvn package
And you can run the jar.


The app is a Spring Boot app so you do not have to install Tomcat or any other web server.

It uses a H2 in memory DB to store the product and read the approproate data from it.
When the app started Spring will create and populate the required PRODUCT table. Yue can check it: localhost:8080/console
Make sure you use this url as JDBC URL: jdbc:h2:mem:testdb

You can see the product selection page on this url: <b>http://localhost:8080/selectProduct</b>


I have use Spring Boot, Spring MVC, Spring Data with JPA, H2 DB technologies.