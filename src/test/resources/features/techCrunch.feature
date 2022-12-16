Feature: As a user I should see that each news has its own image and author from Latest News


  @wip
  Scenario: User sees image and author of each news
    When User lands on the homepage and sees loaded latest news
    Then Verify that each news contains image and author
