package com.techCrunch.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class Utilities {

    public static boolean isImageDisplayed(WebDriver driver, WebElement imageElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return (boolean) javascriptExecutor.executeScript("return arguments[0].complete "
                + "&& typeof arguments[0].naturalWidth != 'undefined'"
                + "&& arguments[0].naturalWidth > 0", imageElement);
    }


}
