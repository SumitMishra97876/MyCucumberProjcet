Feature: Searching a product and adding the product to the cart

@AddtoCart
Scenario Outline: Searching for products and adding the products to cart

Given user logs into account using valid username and password
When user searches for a product "<pname>" on My Account page
And user clicks on search button
And user clicks on product "<pname>" 
And user clicks on Add to cart button
Then the product "<pname>" should be added to cart with a successful message

Examples:

|pname|
|MacBook Pro|
|iMac|