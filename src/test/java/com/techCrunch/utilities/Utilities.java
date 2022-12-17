package com.techCrunch.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static boolean ElementsInCommon(String[] words, String[] words1) {
        int count = 0;
        for (String word : words) {
            for (String word1 : words1) {
                if (word.equals(word1)) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
