Feature: Search book by name
As a: Client
I: would search books by name

Scenario Outline: Search book by name

Given we have library
And we have book named <a>
And we have book named <b>
When we add them to library
Then the result of searching <search> should be <count>

Examples:
    |a|b|search|result|
    |Book1|Book2|Book|2|