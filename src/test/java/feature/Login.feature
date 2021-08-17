Feature: Login

Scenario: login to opencart

Given user is on Login page
When user enters username "sm97876@gmail.com" and password "Sabretooth"
And user clicks on submit button
Then Myaccount page should be displayed

