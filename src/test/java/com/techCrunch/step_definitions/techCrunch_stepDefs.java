package com.techCrunch.step_definitions;

import com.techCrunch.utilities.ConfigurationReader;
import com.techCrunch.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[contains(@class,'post-block')]"));
        // List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));
        for (WebElement eachNews : latestNews) {
            List<WebElement>authors=new LinkedList<>();
            authors.add(eachNews.findElement(By.xpath("//span[@class='river-byline__authors']")));

            for (WebElement author : authors) {
                String eachAuth = author.getText();
                System.out.println("eachAuth = " + eachAuth);
            }

        }

    }
}

