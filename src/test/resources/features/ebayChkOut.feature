Feature: validate ebay checkout functionality

@demo111
Scenario Outline: search product and validate checkout page
	Given User is on Home Page
	And User search for keyword
	| keyword      | <keyword> |
	Then verify that search result displayed correctly
	When user select the filter 
	Then Verify that search result displayed as per filter
	When user select the product 
	Then verify the product information
	And verify that value on product page and checkout page are same
	Then verify that value on product page and guest checkout page are same
	
	Examples:
	|keyword |
	|sony tv |