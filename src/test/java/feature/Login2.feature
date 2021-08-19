Feature:  Positive and Negative Login

Background:
Given user in on Login page

@PositiveNegativeLogin
Scenario: Positive scenario
When the user enters username  and password
And user clicks on submit button
Then Myaccount page should be displayed

@PositiveNegativeLogin
Scenario Outline: Negative Scenarios
When user enters  username "<username>" and password "<password>"
And user clicks on submit button
Then error message should be validated

Examples:
|username|password|
|sm97876@gmail.com|12345|
|sm@gmail.com|Sabretooth|
