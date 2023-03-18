package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImagesPage {
    public ImagesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * There are bunch of Latest News,each news should have an "Image", so they aasdll stored in  as List.
     **/

    @FindBy (xpath ="//img[@sizes='(min-width: 1024px) 430px, 100vw']")
    private List<WebElement>allThumbs;

    public void imageVerification() {
        //List<WebElement> allThumbs = Driver.getDriver().findElements(By.xpath("//img[@sizes='(min-width: 1024px) 430px, 100vw']"));
        //IsImageDisplayed Method checks if the image exist on the addressed locator.

        for (WebElement eachThumb : allThumbs) {
            Assert.assertTrue(Utilities.isImageDisplayed(Driver.getDriver(), eachThumb));
        }
    }
}
