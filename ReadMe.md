# Spring Maven Application With MySQL

## _Basic Spring Application with CRUD operations_

Sample application is to demonstrate integration of MySQL database with Spring application.
Run BasicSpringLab1.java main class to execute the CRUD operations.

## Tech

The application has been developed by following technologies.


- [Amazon Corretto 11](https://docs.aws.amazon.com/corretto/) - Open JDK provided by Amazon.
- [Apache Maven 3.8.1 ](https://maven.apache.org/download.cgi) - Maven Build Tool.
- [Spring Framework ](https://spring.io/) - Spring Version 5.3.9.
- [Oracle MySQL Database](https://dev.mysql.com/downloads/mysql/) - Community Edition ,Version 5.8
- [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/) - IDE Version: 2021-06

## Installation

This application requires Java 1.8+ , Maven build tool, MySQL 5.8x must be installed in the local machine.


- MySQL database server running locally with the respective port number, username and password.

- Create database, table as provided in  _spring-jdbc-mysql/mysql_scripts/database_commands.sql_

- Download sample application in your machine through GitHub.

- Import as a Maven project in your IDE (Here, Eclipse is used) of your choice

- In your terminal window, Navigate to your project directory location and execute below command :

```sh

..\spring-jdbc-mysql> mvn clean package -e -U

```
- Navigate to **BasicSpringLab1.java** in your IDE and run this class as Java application.


## License

The beautiful thing about open source programming community is that its always free.


**Happy Learning!**