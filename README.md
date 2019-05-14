# SampleEcommerce
SampleEcommerce Using Spring / Hibernate / REST

Description : This is a sample ecommerce Java Maven Project which exposes RESTful APIs. It uses Spring and Hibernate frameworks.

## APIs -



1. POST **/api/item** - Add an Item



Sample Request - 

{
	"itemName":"oneplus7",
	"numOfItem":10
}

Sample Response -

{
    "status": "SUCCESS",
    "message": "ITEM ADDED",
    "items": null
}



2. GET **/api/item** - Retrieve all Items



Sample Response - 

{
    "status": "SUCCESS",
    "message": null,
    "items": [
        {
            "itemName": "brush",
            "numOfItem": 0
        },
        {
            "itemName": "camera",
            "numOfItem": 0
        },
        {
            "itemName": "oneplus7",
            "numOfItem": 10
        }
    ]
}



3. PUT **/api/item/{itemName}** - Update an Item, currently quantity of Item can be updated



Sample Request - 

{
	"itemName":"camera",
	"numOfItem":9
}

Sample Response -

{
    "status": "SUCCESS",
    "message": "ITEM UPDATED",
    "items": null
}



4. DELETE **/api/item/{itemName}** - Delete an Item



Sample Response -

{
    "status": "SUCCESS",
    "message": "ITEM DELETED",
    "items": null
}



5. POST **/api/order** - Place one or multiple Orders



Sample Request - 

{
    "orders" : [{
        "itemName":"brush",
        "numOfItem":2,
        "emailID":"vivek@gmail.com"
    }, {
        "itemName":"camera",
        "numOfItem":1,
        "emailID":"vivek@gmail.com"
    }]
}

Sample Response - 

{
    "status": "SUCCESS",
    "message": "ORDER PLACED",
    "orders": null
}



6. GET **/api/order** - Retrieve all Orders



Sample Response - 

{
    "status": "SUCCESS",
    "message": null,
    "orders": [
        {
            "orderID": "1bf3983b-9e73-42a4-8b08-fa2c1d8334b3",
            "itemName": "brush",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "1bf3983b-9e73-42a4-8b08-fa2c1d8334b3",
            "itemName": "camera",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "5757213a-1289-42c1-bcb5-ae8f5ae17d66",
            "itemName": "brush",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "72829e82-82ad-4bf5-8d26-207483e4b3c9",
            "itemName": "paste",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "72829e82-82ad-4bf5-8d26-207483e4b3c9",
            "itemName": "camera",
            "numOfItem": 3,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "4d86f4a4-9aa4-4dbe-9992-2a7cda52b674",
            "itemName": "brush",
            "numOfItem": 10,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "4d86f4a4-9aa4-4dbe-9992-2a7cda52b674",
            "itemName": "camera",
            "numOfItem": 4,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "1b4f9477-8699-470d-9795-e3f65efb6ac4",
            "itemName": "brush",
            "numOfItem": 2,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "1b4f9477-8699-470d-9795-e3f65efb6ac4",
            "itemName": "camera",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "a01da50f-d193-4104-a04d-c598ae8e9281",
            "itemName": "brush",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        },
        {
            "orderID": "a01da50f-d193-4104-a04d-c598ae8e9281",
            "itemName": "camera",
            "numOfItem": 1,
            "emailID": "vivek@gmail.com"
        }
    ]
}



**Code also take cares of following** - out of stock, item already exists, quantity should be >= 0, ordered item quantity is more than item in stock etc


## Database - 


MYSQL database has been used

Hibernate framework has been used


Tables - 

ItemTable - (id Primary Key, itemName, numOfItem)

OrderTable - (id Primary Key, orderID, itemName, numOfItem, emailID)


--------  END --------



