package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import com.techCrunch.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImagesPage {
    public ImagesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * There are bunch of Latest News,each news should have an "Image", so they all stored in  as List.
     **/
    public void imageVerification() {
        List<WebElement> allThumbs = Driver.getDriver().findElements(By.xpath("//img[@sizes='(min-width: 1024px) 430px, 100vw']"));
        //IsImageDisplayed Method checks if the image exist on the addressed locator.

        for (WebElement eachThumb : allThumbs) {
            Utilities.isImageDisplayed(Driver.getDriver(), eachThumb);
        }
    }


}
