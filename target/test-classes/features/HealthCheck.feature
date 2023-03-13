@ui @healthcheck

Feature: E-commerce Project Web Site Health Check

@MobileSearch
Scenario: User is able to open the application and able to perform a search operation for Tablet
Given user opened browser
And user navigated to home page
When user search for "mobile"
Then search result is displayed "mobile"
And user click on any product
Then procuct descrption is opened


@LaptopSearch
Scenario: user is able to open the application and perform search for Laptop
Given user opened browser
And user navigated to home page
When user search for "laptop"
Then search result is displayed "laptop"
And user click on any product
Then procuct descrption is opened

@AddToCart
Scenario: user is able to open application and search for product and add it to shopping cart
Given user opened browser
And user navigated to home page
When user search for "mobile"
Then search result is displayed "mobile"
And user click on any product
Then procuct descrption is opened
And user add product to shopping cart		 #Logik implementation still pending.

@MultiSearch
Scenario: user is able to search for multiple products
Given user opened browser
And user navigated to home page
When user search for product  "<product_name>"
Then search result is displayed for product "<product_result>"

Examples:
|product_name|product_result|
|mobile			 |mobile				|
|jeans			 |jeans			  	|
|jacket			 |jacket				|
#issue with multisearch screenshot capture working for first parameter only.

@FooterOptionsTest
	Scenario: Validate all footer links on landing page of the application
		Given user navigated to home page
    And user scroldown to the botton of the landing page of the application
    When user is able to see 4 main options categories
    And the categories having the option "Get to Know Us", "Connect with Us", "Make Money with Us" and "Let Us Help You"
    Then under Get to Know Us category below options are visible
    | About Us				|
    | Careers					|
    | Press Releases	|
    | Amazon Science	|   
		And under Connect with Us category below options are visible
		| Facebook 	|
		| Twitter		|
		| Instagram	| 
		And under Make Money with Us category below options are visible
		| Sell on Amazon 								|
		| Sell under Amazon Accelerator |
		| Protect and Build Your Brand 	|
		| Amazon Global Selling 				|
		| Become an Affiliate 					|
		| Fulfilment by Amazon 					|
		| Advertise Your Products				|
		| Amazon Pay on Merchants 			|
		And under Let Us Help You category below options are visible
		| COVID-19 and Amazon 			|
		| Your Account 							|
		| Returns Centre 						|
		| 100% Purchase Protection 	|
		| Amazon App Download 			|
		| Amazon Assistant Download |
		| Help 											|
