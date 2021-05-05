# Link Social Media

## Project Description
Link is the second iteration of a social media application created by Team Avatar as part of the Revature Full Stack Angular training program in April 2021. Developed with a microservice architecture, this web application allows every user to follow each other and view each other's posts. Each user has their own account that they can customize with their own information. Within this network, users can interact with each other through comments, likes, and a global chatroom. This social media application is meant to ease the transition of becoming a Revature employee.

Notification handles updating users in a notification bar when their posts are liked and commented on. Once users view their notifications it removes the notification from the notification bar. 

## Technologies Used

-Spring Boot
	- Euereka Discovery Client
	- Spring Boot Actuator
	- Spring Web MVC
	- Java Persistence API
- Java - version 1.8
- PostgrSQL - version 13.2
- JUnit
- Log4J
- H2 Database Testing

## Features

- Notify user when post are liked, or commented on. 
- Remove notification once user has viewed new notifications.

### To-do list:

- TODO

## Getting Started
   
> Clone this repository
```
git clone https://github.com/LinkSocialNetwork/NotificationService.git
```

> Clone Eureka, Gateway, and UserService services
```
git clone https://github.com/LinkSocialNetwork/Eureka.git
git clone https://github.com/LinkSocialNetwork/Gateway.git
```

## **Usage**

> Run the services together, sequentially in an IDE
```
Eureka > Gateway > NotificationService
```

> Visit the Eureka url and confirm Eureka can see the Gateway, NotificationService
```
http://localhost:9999/Eureka
```

> Run angular project
```
cd FrontendClient/Angular
npm run start
```

> Visit the frontend url
```
http://localhost:4200
```

## **License**

This project uses the following license: [<The MIT License>](https://www.mit.edu/~amini/LICENSE.md).
