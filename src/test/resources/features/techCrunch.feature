
@test
Feature: As a user I should see that each news has its own image and author from Latest News


  @test1
  Scenario: User sees image and author of each news
    When User lands on the homepage and sees loaded latest news
    Then Verify that each news contains author
    Then Verify that each news contains image

  @test2
  Scenario: Browser title is the same with the news title and the links within the news content
    When User lands on the homepage and sees loaded latest news
    And  User clicks randomly one of the news from Latest News
    Then Verify that the browser title is the same with the news title and the links within the news content