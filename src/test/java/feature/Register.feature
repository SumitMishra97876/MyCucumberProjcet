Feature: Registration of users
@Register
Scenario Outline: Registering multiple users

Given user is on Registration page
When user enter details from excel "<row>"
And user checks on privacy checkbox
And user clicks on continue button
Then user should be registered with a successful message

Examples:
|row|
|1|
|2|
|3|
|4|
