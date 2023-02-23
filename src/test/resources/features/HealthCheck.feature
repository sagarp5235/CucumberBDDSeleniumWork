@ui @healthcheck

Feature: E-commerce Project Web Site Health Check

Scenario: User is able to open the application and able to perform a search operation for Tablet

Given user opened browser
And user navigated to home page
When user search for "mobile"
Then search result is displayed "mobile"
And user click on any product
Then procuct descrption is opened 
And  browser is closed