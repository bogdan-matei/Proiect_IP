**GET_notifications**
----
  

* **URL**

  _v1/users/{userId}/notifications_

* **Method:**
  
  `GET` 
  
*  **URL Params**

   **Required:**
 
   `userId=[integer]`


* **Data Params**

  _N/A for GET verb_

* **Success Response:** 

  * **Code:** 200 OK <br />
    **Content:** 
```json
{
    "notificationsList" : [
        {
            "id": 23,
            "text": "Wake me up",
            "time" : 1231245,
            "repeatable" : true,
            "interval" : 300
        },
        {
            "id": 24,
            "text": "Get the kid",
            "time" : 123245,
            "repeatable" : false,
            "interval" : 400
        }
    ],
    "error" : "Whatever error string"
}
```
 
* **Error Response:**

  * **Code:** 422 Unprocessable Entry <br />
    **Content:** `{ error : "Invalid User" }`

  * **Code:** 400 Bad Request <br />
    **Content:** `{ error : "Input criteria not correct" }`

* **Notes:**

  _No aditional info available_
 
