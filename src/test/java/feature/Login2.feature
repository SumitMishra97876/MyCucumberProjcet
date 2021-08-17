Feature:  Positive and Negative Login

Scenario: Positive scenario
Given user is on Login page
When the user enters username  and password
And user clicks on submit button
Then Myaccount page should be displayed

Scenario Outline: Negative Scenarios
Given user is on Login page
When user enters  username "<username>" and password "<password>"
And user clicks on submit button
Then error message should be validated

Examples:
|username|password|
|sm97876@gmail.com|12345|
|sm@gmail.com|Sabretooth|
