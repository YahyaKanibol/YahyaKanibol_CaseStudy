package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AuthorsPage {
    public AuthorsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * There are bunch of Latest News,each news should have an "Author", so they all stored in  as List.
     **/


    public void authorVerification() {
        List<WebElement> allAuthors = Driver.getDriver().findElements(By.xpath("//span[@class='river-byline__authors']"));
        for (WebElement eachAuthor : allAuthors) {
            String eachAuthorsName = eachAuthor.getText();
            System.out.println("eachAuthor = " + eachAuthorsName);
            Assert.assertNotNull(eachAuthor);
        }
    }
}
