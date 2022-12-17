package com.techCrunch.step_definitions;

import com.techCrunch.pages.LatestNews;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class secondScenerio_stepDefs {

    LatestNews latestNews=new LatestNews();
    @When("User clicks randomly one of the news from Latest News")
    public void user_clicks_randomly_one_of_the_news_from_latest_news() {
        latestNews.get_all_the_LatestNews_collectData();
    }

    @Then("Verify that the browser title is the same with the news title and the links within the news content")
    public void verify_that_the_browser_title_is_the_same_with_the_news_title_and_the_links_within_the_news_content() {
        latestNews.assert_and_verify();
    }
}
