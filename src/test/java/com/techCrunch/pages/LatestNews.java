package com.techCrunch.pages;

import com.techCrunch.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LatestNews {
    public LatestNews() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//article[contains(@class,'post-block')]")
    private WebElement news;





}
