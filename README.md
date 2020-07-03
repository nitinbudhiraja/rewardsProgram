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

## Usage
Application can be used to Add Transactions for customer and View reward points for customers.

**1 : Add Transaction screen** : *This is the [home page](http://localhost:8081/home) and provides UI to adds trancation data.*

<img width="1127" alt="Capture1" src="https://user-images.githubusercontent.com/7859008/86426727-37c89100-bc9d-11ea-86f8-f0d03442e2ef.PNG">


<img width="1127" alt="Capture2" src="https://user-images.githubusercontent.com/7859008/86426790-66df0280-bc9d-11ea-9f6e-f42fb171a2f3.PNG">

**2 : View Customer Rewards screen** : *This [screen](http://localhost:8081/rewards/getRewards) displays the  monthly and total reward points earned by all customers in last 3 months.*

<img width="1127" alt="Get rewards" src="https://user-images.githubusercontent.com/7859008/86426941-cf2de400-bc9d-11ea-9206-45b3e41bcefa.PNG">

