<p align="center">
  <img width="100" height="100" src="https://media.glassdoor.com/sqll/1172252/atlantbh-squarelogo-1508334484095.png">
</p>

# Bid.ba 

 A web auction platform for vintage items developed during [Atlantbh](https://www.atlantbh.com/) Internship (October 2021 - February 2022).
 Monthly tasks were tracked via [Trello](https://trello.com/) and the development progress was presented at the end of each month. I have collaborated with a QA intern and a dedicated mentor to ensure the successful implementation of the platform. <br/><br/> 
 Check it out --> <a href="https://bidba.herokuapp.com/" target="_blank">https://bidba.herokuapp.com</a> <br/><br/> 

 ## Tech stack for backend

 - **Spring Boot** - The Spring Framework is an application framework and inversion of control container for the Java platform
 - **PostgreSQL** - A free and open-source relational database management system emphasizing extensibility and SQL compliance
 - **Flyway** - An open-source database migration tool used for database-first approach
 - **Heroku** - A platform as a service (PaaS) that enables developers to build, run, and operate applications in the cloud (used for hosting)

 <p>
 <img align="left" width="100" height="100" src="https://pbs.twimg.com/profile_images/1235868806079057921/fTL08u_H_400x400.png">
 <img align="left" width="100" height="100" src="https://www.postgresql.org/media/img/about/press/elephant.png">
   <img align="left" width="100" height="100" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Flyway_logo.svg/1200px-Flyway_logo.svg.png">
 <img align="left" width="100" height="100" src="https://gluonhq.com/wp-content/uploads/2018/05/heroku-logotype-vertical-purple-253x300@2x.png">
 </p><br/><br/><br/><br/>  

<br/><br/>  
## Connecting to the database: 
1. Create a database with name
   - `auction`
2. Set local environment variables
   - `APPLICATION_PORT` _(default: 8080)_
   - `APPLICATION_DB_USER` _(default: postgres)_
   - `APPLICATION_DB_PASSWORD` _(default: admin)_
3. Set DB url _(optional)_
   - `APPLICATION_DB_URL` _(default: localhost)_
   - `APPLICATION_DB_PORT` _(default: 5432)_
   - `APPLICATION_DB_NAME` _(default: auction)_
 
## Swagger API documentation
--> [https://bidba-api.herokuapp.com/swagger-ui/](https://bidba-api.herokuapp.com/swagger-ui/)

## Main functionality

 - Login and registration with JWT authentication
 - GET, POST, PUT endpoints
 - Filtering and sorting using JPA Specification and Builder & Factory design patterns
 - 'Did you mean...?' functionality using Levenshtein distance
 - Pagination
 - Payment processing with Stripe integration
 - Swagger and Flyway integration
 - Deployment
