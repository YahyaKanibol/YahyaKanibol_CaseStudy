package com.techCrunch.step_definitions;

import com.techCrunch.pages.LatestNews;
import com.techCrunch.utilities.ConfigurationReader;
import com.techCrunch.utilities.Driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class techCrunch_stepDefs {
    LatestNews latestNews=new LatestNews();

    @When("User lands on the homepage and sees loaded latest news")
    public void user_lands_on_the_homepage_and_sees_loaded_latest_news() {
        latestNews.goToPage();Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("Verify that each news contains author")
    public void verify_that_each_news_contains_author() {
        latestNews.authorVerification();
    }

    @Then("Verify that each news contains image")
    public void verify_that_each_news_contains_image() {
        latestNews.imageVerification();
    }
}

