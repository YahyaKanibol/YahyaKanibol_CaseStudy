package com.techCrunch.step_definitions;

import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class secondScenerio_stepDefs {


    String browserTitle = "";
    String browserTitleAsString ="";
    String currentURL = "";
    String newsTitle = "";
    String urlAsString="";
    String expectBrowserTitlePure="";
    String[] eachWord_of_the_URL =null;
    String[] eachWord_of_the_BrowserTitle =null;

    @When("User clicks randomly one of the news from Latest News")
    public void user_clicks_randomly_one_of_the_news_from_latest_news() {
        List<WebElement> latestNews = Driver.getDriver().findElements(By.xpath("//article[contains(@class,'post-block')]"));
        Random random= new Random();
        int randomIndex = random.nextInt(latestNews.size());

        newsTitle = (latestNews.get(randomIndex)).getText();
        latestNews.get(randomIndex).click();
        browserTitle = Driver.getDriver().getTitle();
        browserTitleAsString =browserTitle.substring(0,(browserTitle.indexOf("|")-1));
        currentURL = Driver.getDriver().getCurrentUrl();
        urlAsString=Utilities.URLToString(currentURL);
        eachWord_of_the_URL = urlAsString.split(" ");
        expectBrowserTitlePure = browserTitleAsString.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        eachWord_of_the_BrowserTitle = expectBrowserTitlePure.split(" ");

        System.out.println("***NEWS TITLE = " + newsTitle);
        System.out.println(" ");
        System.out.println("***BROWSER TITLE = " + browserTitle);
        System.out.println(" ");
        System.out.println("***CURRENT URL = " + currentURL);
        System.out.println(" ");
        System.out.println("***URL AS STRING = " + urlAsString);
        System.out.println(" ");
        System.out.println("***RANDOM INDEX= " + randomIndex);
        System.out.println(" ");
        System.out.println("***BROWSER TITLE AS STRING= " + browserTitleAsString);
        System.out.println(" ");
        System.out.println("expectBrowserTitlePure = " + expectBrowserTitlePure);
        System.out.println(" ");
        System.out.println("URL as Array= " + Arrays.toString(eachWord_of_the_URL));
        System.out.println(" ");
        System.out.println("Browser Title in Array = " + Arrays.toString(eachWord_of_the_BrowserTitle));

    }

    @Then("Verify that the browser title is the same with the news title and the links within the news content")
    public void verify_that_the_browser_title_is_the_same_with_the_news_title_and_the_links_within_the_news_content() {
        /*Firstly, we verify that browser title is exactly contained in news title*/
        Assert.assertTrue(newsTitle.contains(browserTitleAsString));
        /*Secondly, we verify that the words of news'  URL is matches with news' content*/
        Assert.assertTrue(Utilities.ElementsInCommon(eachWord_of_the_URL, eachWord_of_the_BrowserTitle));
    }
}
