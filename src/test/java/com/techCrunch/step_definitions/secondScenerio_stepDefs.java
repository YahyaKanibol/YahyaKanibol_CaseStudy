package com.techCrunch.step_definitions;

import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class secondScenerio_stepDefs {


    String browserTitle = "";
    String expectedBrowserTitle="";
    String currentURL = "";
    String newsTitle = "";
    //.findElement(By.xpath("//h2[@class='post-block__title']"))



    @When("User clicks randomly one of the news from Latest News")
    public void user_clicks_randomly_one_of_the_news_from_latest_news() {
        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[contains(@class,'post-block')]"));
        Random random= new Random();
        int randomIndex = random.nextInt(latestNews.size());

        newsTitle = (latestNews.get(randomIndex)).getText();
        latestNews.get(randomIndex).click();
        browserTitle = Driver.getDriver().getTitle();
        expectedBrowserTitle=browserTitle.substring(0,(browserTitle.indexOf("|")-1));
        currentURL = Driver.getDriver().getCurrentUrl();
        Utilities.URLToString(currentURL);

       /*
        System.out.println("newsTitle = " + newsTitle);
        System.out.println("getBrowserTitle = " + browserTitle);
        System.out.println("getCurrentLink = " + getCurrentLink);
        System.out.println("a = " + randomIndex);
        System.out.println("expectedBrowserTitle = " + expectedBrowserTitle);
        System.out.println("newCurrentlink = " + newCurrentlink);
        */





    }

    @Then("Verify that the browser title is the same with the news title and the links within the news content")
    public void verify_that_the_browser_title_is_the_same_with_the_news_title_and_the_links_within_the_news_content() {
        Assert.assertTrue(newsTitle.contains(expectedBrowserTitle));
        Assert.assertTrue(expectedBrowserTitle.toLowerCase().contains(Utilities.URLToString(Driver.getDriver().getCurrentUrl())));

    }
}
