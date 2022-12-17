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

    public static String URLToString(String link){

        String subs= link.substring(34,link.length()-1);
        return subs.replace("-"," ");
    }

    public static boolean compareEachInCommon(String[] arr, String[] arr2) {
        int count = 0;
        for (String word : arr) {
            for (String word1 : arr2) {
                if (word.equals(word1)) {
                    count++;
                    if (count >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
