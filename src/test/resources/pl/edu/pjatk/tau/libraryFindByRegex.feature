Feature: Search book by regex
As a: Client
I: would search books by regex

Scenario: Search book by regex

Given we have library
And we have book named "Ala w lesie"
And we have book named "Lasy deszczowe"
When we add them to library
Then the result of searching "^[a-zA-Z]{4}.*$" should be Book named "Lasy deszczowe"
But the result of searching "^[a-zA-Z]{4}.*$" shouldn't be Book named "Ala w lesie"
