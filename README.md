# Rewards Sample Application 
Deploy this sample application to calculate the reward points earned for each customer per month and total. 



## Running reward program locally via command prompt
Reward program is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application backed by in memory H2 database and built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
mvn clean install
mvn spring-boot:run -Dserver.port=8081
```

## Running reward program locally via IDE
Clone and import the code to IDE and run RewardsApplication class.

## APIs

**1 : Transaction Add API** : *This Api adds trancation data to data store.*

`curl -X POST "http://localhost:8081/transactions/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"amount\": 100, \"customerId\": 202, \"transactionDate\": \"2020-02-06\"}"`

**2 : Rewards Get API** : *This Api gets the reward point earned by all customers in last 3 months.*

`curl -X GET "http://localhost:8081/rewards/getRewards" -H "accept: */*"`

## Swagger (Api documentation)

Application is intergated with [Swagger](https://swagger.io/) You can then access rewards program Api's here: http://localhost:8081/swagger-ui.html



<img width="1042" alt="swagger-main" src="https://user-images.githubusercontent.com/7859008/86301944-16dc3f00-bbbc-11ea-8bdb-2cf5b85b3c80.PNG">

*Select the Api and click "Try it out" to access the APIs*

**Transaction Add**
<img width="1095" alt="Transaction-add-swagger" src="https://user-images.githubusercontent.com/7859008/86302883-f661b400-bbbe-11ea-8249-2cd4b9dc4e0e.PNG">

**Rewards Get**
<img width="1066" alt="Rewards-get-swagger" src="https://user-images.githubusercontent.com/7859008/86302886-f82b7780-bbbe-11ea-9b1a-cb4729c613cc.PNG">
