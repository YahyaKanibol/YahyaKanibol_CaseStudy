package com.techCrunch.step_definitions;

import com.techCrunch.pages.AuthorsPage;
import com.techCrunch.pages.ImagesPage;
import com.techCrunch.pages.LatestNews;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class techCrunch_stepDefs {
    LatestNews latestNews=new LatestNews();
    AuthorsPage authorsPage=new AuthorsPage();
    ImagesPage imagesPage=new ImagesPage();

    @When("User lands on the homepage")
    public void user_lands_on_the_homepage() {
        latestNews.goToPage();
    }

    @Then("Verify that each news contains author")
    public void verify_that_each_news_contains_author() {
        authorsPage.authorVerification();
    }

    @Then("Verify that each news contains image")
    public void verify_that_each_news_contains_image() {
        imagesPage.imageVerification();
    }

    @When("User clicks randomly one of the news from Latest News")
    public void user_clicks_randomly_one_of_the_news_from_latest_news() {
        latestNews.get_all_the_LatestNews_collectData();
    }

    @Then("Verify that the browser title is the same with the news title")
    public void verify_that_the_browser_title_is_the_same_with_the_news_title() {
        latestNews.browserTitle_and_NewsTitle_verification();
    }
    @Then("Verify that the links within the news content")
    public void verify_that_the_links_within_the_news_content() {
        latestNews.links_Within_the_NewsContent();

    }
}

