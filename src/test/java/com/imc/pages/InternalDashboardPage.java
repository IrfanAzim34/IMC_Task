package com.imc.pages;

import com.imc.utils.BrowserUtils;
import com.imc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalDashboardPage {

    LogInPage logInPage = new LogInPage();

    public InternalDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void verifyPageLoaded() {
        BrowserUtils.waitForElementVisible(this.allContents);
        Assert.assertTrue(this.userProfileBtn.isDisplayed());
    }

    public void logOut() {
        this.userProfileBtn.click();
        this.logOutBtn.click();
        Assert.assertTrue(logInPage.logInBtn.isDisplayed());
    }

    public void navigateToClientManager() {
        this.categorySwitchBtn.click();
        this.adminBtn.click();
        this.peopleDropDown.click();
        this.clientManagerBtn.click();
    }

    @FindBy(xpath = "//a[@title='User profile folder']")
    public WebElement userProfileBtn;

    @FindBy(xpath = "//div[@id='dashboards-section']")
    public WebElement allContents;

    @FindBy(id = "navi_item_logout")
    public WebElement logOutBtn;

    @FindBy(xpath = "//a[@title='Categories switch']")
    public WebElement categorySwitchBtn;

    @FindBy(xpath = "//button[@id='administrator']")
    public WebElement adminBtn;

    @FindBy(xpath = "//a[@title='People']")
    public WebElement peopleDropDown;

    @FindBy(id = "navi_item_organisation_client_manager")
    public WebElement clientManagerBtn;

    @FindBy(xpath = "//a[@title='Catalogue']")
    public WebElement catalogueBtn;

}
