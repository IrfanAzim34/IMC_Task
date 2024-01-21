package com.imc.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void threadWait(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(WebElement element){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void switchInFrame(WebElement frameElement){
        Driver.getDriver().switchTo().frame(frameElement);
    }

    public static void switchBackMainHtml(){
        Driver.getDriver().switchTo().defaultContent();
    }

    public static void scrollDownToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitUntilAllWindowsOpen(int numberOfWindows){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(Driver.getDriver(), 10)
                .until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}