</br>
<p align="center">
  <a href="http://egobooster.net/">
    <img alt="GitPoint" title="GitPoint" src="https://github.com/sohekim/egobooster/blob/master/src/main/resources/static/images/logoWithText.png" width="180">
  </a>
</p>

</br>
<p align="center">
  <b>Find, Share, and Subscribe To Ego Booster.</b>
  <p>
<p align="center">
  <b>API Server and Web Server Built with Spring Boot Deployed To AWS.</b>
</p>
</br>





## Table of Contents

- [Features](#features)
- [Implementation](#implementation)
- [API Documentation](#api)
- [Feedback](#feedback)
</br>




## Features 
A few of the things you can do with EgoBooster 🔥 
* Personalize Ego Booster Quotes with custom links
* Find Ego Booster Quotes
* Email Subscription Service
* Public Ego Boosters RESTful API
</br>




## Implementation

| Framework            | Deployment     | Database               | Others    |
| -------------------- |----------------| -----------------------| ----------|
| Spring Boot          | AWS EC2.       | Spring Boot Data Redis |Junit      |
| Spring Boot Data JPA | AWS RDS        | MySQL                  |Thymeleaf Template Engine |
| Spring Boot Web      | AWS ElastiCache|                        |Swagger    |

</br>




## API Documentation

### Definition of REST

| HTTP Method  | Usage           |
| ------------ |-----------------|
| GET          | Read existing resource        |
| PUT          | Overwrite existing resource    |
| POST         | Create new resource      |
| DELETE       | Delete given resource       |

### Booster related REST Endpoints

#### Retrieve Boosters
Endpoint to get all or filtered Boosters
> **GET** /api/v1/boosters

**Possible Parameters**


| Parameter  | Parameter Type |Description      |Required     |
| -----------|----------------|-----------------|-------------| 
| keyword    | String         |keyword to query |No           |
| page       | Integer        |page of paging   |No           |
| size       | Integer        |size of paging   |No           |


**Sample Responses**

**200 OK**
```
[
  {
    "id": 0,
    "text": "string",
    "updateDate": "2021-04-15T10:34:28.155Z"
  }
]
```

**404 Not Found**


### - Batch
### - Subscription
</br>




## Feedback
More than welcome to send any feedback / feature request by filling an issue or email
