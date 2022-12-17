
@test
Feature:Latest News on Tech Crunch


  @test1
  Scenario: Each news should have an author and image
    When User lands on the homepage
    Then Verify that each news contains author
    Then Verify that each news contains image

  @test2
  Scenario: Browser title is the same with the news title and the links within the news content
    When User lands on the homepage
    And  User clicks randomly one of the news from Latest News
    Then Verify that the browser title is the same with the news title
    Then Verify that the links within the news content