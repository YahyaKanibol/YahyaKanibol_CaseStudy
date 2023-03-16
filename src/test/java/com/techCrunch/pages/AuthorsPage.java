package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AuthorsPage {
    public AuthorsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * There are bunch of Latest News,each news should have an "Author", so they all stored in  as List.
     **/

    @FindBy (xpath = "//span[@class='river-byline__authors']")
    private List<WebElement>allAuthors;



    public void authorVerification() {
       // List<WebElement> allAuthors = Driver.getDriver().findElements(By.xpath("//span[@class='river-byline__authors']"));
        //int count=1;
        for (WebElement eachAuthor : allAuthors) {
            String eachAuthorsName = eachAuthor.getText();
            Assert.assertTrue(eachAuthorsName.trim().length() > 0 );
            //System.out.println("Author"+" "+count+++"=" + eachAuthorsName);
        }
    }
}
