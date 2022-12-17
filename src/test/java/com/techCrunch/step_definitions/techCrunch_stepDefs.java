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

    @When("User lands on the homepage and sees loaded latest news")
    public void user_lands_on_the_homepage_and_sees_loaded_latest_news() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("Verify that each news contains image and author")
    public void verify_that_each_news_contains_image_and_author() {

        List<WebElement> allAuthors = Driver.getDriver().findElements(By.xpath("//span[@class='river-byline__authors']"));
        for (WebElement eachAuthor : allAuthors) {
            String eachAuthorsName = eachAuthor.getText();
            System.out.println("eachAuthor = " + eachAuthorsName);
            Assert.assertNotNull(eachAuthor);
        }

        List<WebElement> allThumbs = Driver.getDriver().findElements(By.xpath("//img[@sizes='(min-width: 1024px) 430px, 100vw']"));
        for (WebElement eachThumb : allThumbs) {
           Utilities.isImageDisplayed(Driver.getDriver(),eachThumb);
        }
    }
}

