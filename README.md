</br>
</br>


<p align="center">
  <a href="http://egobooster.net/">
    <img alt="GitPoint" title="GitPoint" src="https://github.com/sohekim/egobooster/blob/master/src/main/resources/static/images/logoWithText.png" width="180">
  </a>
</p>

</br>
<p align="center">
  <b>Find, Share, and Subscribe To Ego Booster</b>
  <p>
<p align="center">
  <b>API Server and Web Server Built with Spring Boot Deployed To AWS</b>
</p>
</br>

```

⛔️ If the website is not responding, it's probably because the server exceeded the AWS free tier limit

```
</br>


## Table of Contents

- [Features](#features)
- [Implementation](#implementation)
- [API Documentation](#api-documentation)
- [Feedback](#feedback)

</br>
</br>

## Features 
A few of the things you can do with EgoBooster 🔥 
* Personalize Ego Booster Quotes with custom links
* Find Ego Booster Quotes
* Email Subscription Service
* Public Ego Boosters RESTful API
</br>

<img title="GitPoint" src="https://github.com/sohekim/egobooster/blob/master/src/main/resources/static/images/docs.png" width=100%>

</br>
</br>

## Implementation

| Framework            | Deployment     | Database               | Others    |
| -------------------- |----------------| -----------------------| ----------|
| Spring Boot          | AWS EC2.       | Spring Boot Data Redis |Junit      |
| Spring Boot Data JPA | AWS RDS        | MySQL                  |Thymeleaf Template Engine |
| Spring Boot Web      | AWS ElastiCache|                        |Swagger    |

</br>

<img alt="GitPoint" title="GitPoint" src="https://github.com/sohekim/egobooster/blob/master/src/main/resources/static/images/architect.png" width=65%>

</br>
</br>

## API Documentation

Please reference [Swagger Documentation](http://egobooster.net/swagger-ui/index.html#/) for all REST Endpoints

### Definition of REST

| HTTP Method  | Usage                         |
| ------------ |-------------------------------|
| GET          | Read existing resource        |
| PUT          | Overwrite existing resource   |
| POST         | Create new resource           |
| DELETE       | Delete given resource         |

</br>

### Authentication

End points to write resources must be authenticated. 

#### Shared Secret Key
To access the enpoints to write or delete resources, you need an API Key in your header request for Authorization. If you don't have the correct key, you will get **403 Forbidden** Response code.

</br>

### 1. Retrieve Boosters
Endpoint to get all or filtered Boosters
> **GET** /api/v1/boosters

**Possible Parameters**

| Parameter  | Parameter Type |Description      |Required     |
| -----------|----------------|-----------------|-------------| 
| keyword    | @QueryParam    |keyword to query |No           |
| page       | @QueryParam    |page of paging   |No           |
| size       | @QueryParam    |size of paging   |No           |


**Sample Responses**

- Return Value : **200 OK**
```
[
  {
    "id": 1,
    "text": "When you recover or discover something that nourishes your soul and brings joy, care enough about yourself to make room for it in your life.",
    "updateDate": "2021-04-06T19:54:54"
  },
  {
    "id": 2,
    "text": "Until you value yourself, you won’t value your time. Until you value your time, you will not do anything with it.",
    "updateDate": "2021-04-06T19:55:24"
  },
  {
    "id": 3,
    "text": "An individual cannot be comfortable without their own approval.",
    "updateDate": "2021-04-06T19:55:34"
  },
]
```

- Return Value : **404 Not Found**

</br>

### 2. Save a Booster
Endpoint to save a Booster
> **POST** /api/v1/boosters

**Possible Parameters**


| Parameter  | Parameter Type |Description      |Required     |
| -----------|----------------|-----------------|-------------| 
| boosterDto | @QueryParam    |booster to save  |Yes          |

**Sample Booster DTO**

```
{
    "text" : "We generate fears while we sit. We overcome them by action."
}
```


**Sample Responses**

- Return Value : **201 Created**

  - Headers
  
    ```
    {
        location : /api/v1/boosters/{id}
    }
    ```

- Return Value : **409 Conflict**

- Return Value : **403 Forbidden**

</br>

### 3. Personalize a Booster
Endpoint to personalize a Booster
> **POST** /api/v1/boosters/{id}/personalize

**Possible Parameters**


| Parameter  | Parameter Type |Description               |Required     |
| -----------|----------------|--------------------------|-------------| 
| id         | @Path          |booster id                |Yes          |
| giftee     | @QueryParam    |person to receive booster |No           |
| gifter     | @QueryParam    |person to give booster    |No           |


**Sample Responses**

- Return Value : **200 OK**

```
{
    "id": 3,
    "text": "An individual cannot be comfortable without their own approval.",
    "updateDate": "2021-04-06T19:55:34",
    "gifter": "",
    "giftee": ""
}
```

```
{
    "id": 3,
    "text": "An individual cannot be comfortable without their own approval.",
    "updateDate": "2021-04-06T19:55:34",
    "gifter": "Sohee",
    "giftee": ""
}
```

```
{
    "id": 3,
    "text": "An individual cannot be comfortable without their own approval.",
    "updateDate": "2021-04-06T19:55:34",
    "gifter": "Sohee",
    "giftee": "Minwoo"
}
```

- Return Value : **404 Not Found**

</br>

## Feedback
More than welcome to send any feedback / feature request by filling an issue or email 🐻 🐰

