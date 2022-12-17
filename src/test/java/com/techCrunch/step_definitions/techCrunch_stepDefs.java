package com.techCrunch.step_definitions;

import com.techCrunch.pages.LatestNews;
import com.techCrunch.utilities.ConfigurationReader;
import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class techCrunch_stepDefs {
    LatestNews latestNews=new LatestNews();

    @When("User lands on the homepage and sees loaded latest news")
    public void user_lands_on_the_homepage_and_sees_loaded_latest_news() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
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

