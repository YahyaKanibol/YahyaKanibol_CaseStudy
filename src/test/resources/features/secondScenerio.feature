
Feature:  Click one of news from “The Latest News” list to reach the full content and verify

@wip2
Scenario: the browser title is the same with the news title and the links within the news content

When User lands on the homepage and sees loaded latest news
And  User clicks randomly one of the news from Latest News
Then Verify that the browser title is the same with the news title and the links within the news content
