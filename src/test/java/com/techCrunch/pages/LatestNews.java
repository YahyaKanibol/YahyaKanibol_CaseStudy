package com.techCrunch.pages;

import com.techCrunch.utilities.ConfigurationReader;
import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LatestNews extends LatestNewsBase {
    public LatestNews() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * There are bunch of Latest News,each news  stored in "latestNews" as List.
     **/

    public void goToPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @FindBy (xpath ="//article[contains(@class,'post-block')]")
    private List<WebElement>latestNews;

    public void get_all_the_LatestNews_collectData() {

        // In order to select random from the Latest News, Random is used.
        Random random = new Random();
        int randomIndex = random.nextInt(latestNews.size());

        //One of the news is selected, and we should get the header before click the news.
        newsTitleBeforeClick = (latestNews.get(randomIndex)).getText();

        //Selected news is clicked
        latestNews.get(randomIndex).click();

        //After clicked on the news, the title of the page is stored as "browserTitle"
        browserTitle = Driver.getDriver().getTitle();

        //Browser title is needed to get rid of "TechCrunch" brand to compare with News Title
        onlyBrowserTitle = browserTitle.substring(0, (browserTitle.indexOf("|") - 1));

        //Current URL is needed to get it's content
        currentURL = Driver.getDriver().getCurrentUrl();

        //Current URL needs to get rid of protocol and service name, URLToString method is created and used for this purpose.
        urlAsString = Utilities.URLToString(currentURL);

        //Current URL needs to be stored in an Array as words to be compared with Browser title,
        eachWord_of_the_URL = urlAsString.split(" ");

        //Browser title without special characters,
        browserTitlePure = onlyBrowserTitle.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        //Browser title needs to be stored in array as words to be compared with news' URL
        eachWord_of_the_BrowserTitle = browserTitlePure.split(" ");

       /* System.out.println("***RANDOM INDEX= " + randomIndex);
        System.out.println(" ");
        System.out.println("***NEWS TITLE = " + newsTitleBeforeClick);
        System.out.println(" ");
        System.out.println("***BROWSER TITLE = " + browserTitle);
        System.out.println(" ");
        System.out.println("***BROWSER TITLE AS WITHOUT BRAND= " + onlyBrowserTitle);
        System.out.println(" ");
        System.out.println("***CURRENT URL = " + currentURL);
        System.out.println(" ");
        System.out.println("***URL AS STRING = " + urlAsString);
        System.out.println(" ");
        System.out.println("***BrowserTitlePure = " + browserTitlePure);
        System.out.println(" ");
        System.out.println("[URL as Array]= " + Arrays.toString(eachWord_of_the_URL));
        System.out.println(" ");
        System.out.println("[Browser Title in Array] = " + Arrays.toString(eachWord_of_the_BrowserTitle));*/
    }
    public void browserTitle_and_NewsTitle_verification() {
        /*Firstly, we verify that browser title is exactly contained in news title*/
        Assert.assertTrue(newsTitleBeforeClick.contains(onlyBrowserTitle));
    }
    public void links_Within_the_NewsContent() {
        /*Secondly, we verify that the words of news' URL matches with news' content (News content is inherited from browser's title)*/
        Assert.assertTrue(Utilities.compareEachInCommon(eachWord_of_the_URL, eachWord_of_the_BrowserTitle));
    }
}
