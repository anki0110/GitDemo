Feature: Search and place order for the products.

@offerpage
Scenario Outline: Search Experience for product search in both home page and offer page

Given User is on Greencart landing page.
When User searched with shortname <name> and extracted actual name of product
Then User searched for <name> shortname in offers page to check if product exists
And validate if home page and offer page products are same

Examples:
|name|
|Tom|
|Beet|