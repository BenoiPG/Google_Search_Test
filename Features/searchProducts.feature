Feature: searching products 

Scenario Outline: Searching products on google 

Given i am on the google homepage 

When i enter the "<product_name>" in the search bar 
And i click on the search bar 

Then i can see the result sucessfully 

Examples: 
|product_name|
|Toy         |
|Computer    | 