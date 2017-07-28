package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Tools {


    public static String getCurDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    public static String getStackTrace(Throwable problem) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        problem.printStackTrace(printWriter);
        return result.toString();
    }

    public static String getRandomUserEmail() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_");
        return sdf.format(new Date(System.currentTimeMillis())) + String.valueOf(System.currentTimeMillis()).substring(10,13) + "@somedomain.com";
    }

    public static float convertStringPriceToFloat(String strPrice){
        return Float.valueOf(strPrice.replace("$","").replace(",",""));
    }

    /**
    public static String TestAllLinks(List<WebElement> linkElements) {
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

        //test each link
        for (String t : linkTexts) {

            BasePage.findElement(By.linkText(t)).click();


        }

    } */
}


