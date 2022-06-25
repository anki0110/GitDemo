Feature: Place order for the products.

@placeorder
Scenario Outline: Adding product experience for product search in both home page and offer page

Given User is on Greencart landing page.
When User searched with shortname <name> and extracted actual name of product
And added "3" items of the selected products to cart and proceeds to checkout
Then validate the <name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|name|
|Tom|

