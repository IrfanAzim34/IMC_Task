package com.imc.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /**
     * mainly for using for code debugging, stop thread for specific time
     * @param second
     */
    public static void threadWait(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * explicit wait before element visible
     * @param element (target element)
     */
    public static void waitForElementVisible(WebElement element){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Switch into any frame
     * @param frameElement
     */
    public static void switchInFrame(WebElement frameElement){
        Driver.getDriver().switchTo().frame(frameElement);
    }

    /**
     * Driver will directly back to main HTML
     */
    public static void switchBackMainHtml(){
        Driver.getDriver().switchTo().defaultContent();
    }

    /**
     * scroll down to target element
     * @param element
     */
    public static void scrollDownToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * when there are more than one windows needs to open, this method will count total windows number
     * and compare with expected number of windows
     * @param numberOfWindows
     */
    public static void waitUntilAllWindowsOpen(int numberOfWindows){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(Driver.getDriver(), 10)
                .until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}