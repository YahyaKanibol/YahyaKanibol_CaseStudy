package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LatestNews {
    public LatestNews() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

 /*Since all the web elements are required to store in lists, there is no single WebElement to be stored in Pages package. */

}
