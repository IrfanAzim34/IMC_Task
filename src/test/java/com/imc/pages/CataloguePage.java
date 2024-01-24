package com.imc.pages;

import com.imc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CataloguePage extends InternalDashboardPage {

    public CataloguePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void checkFilterPreSet(String title) {
        Assert.assertTrue(
                this.filterPreSet.isDisplayed() &&
                        this.filterPreSet.getText().trim().equals(title));
    }

    public void search(String subject) {
        this.searchBox.sendKeys(subject);
        this.searchBtn.click();
    }

    @Override
    public void verifyPageLoaded() {
        Assert.assertTrue(this.allContents.isDisplayed());
    }

    @FindBy(xpath = "//a[@class='imc-subnavigation-header__breadcrumbs__item__link']")
    public WebElement dashboardBtn;

    @FindBy(xpath = "//div[@class='grid-x grid-margin-x display-result']")
    public WebElement allContents;

    @FindBy(xpath = "//button[@class='imc-filter-summary-bar__item']")
    public WebElement filterPreSet;

    @FindBy(xpath = "//one-column-list-item//a/div[2]/div/div[1]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//button[@class='imc-filter-summary-bar__item']/span[2]")
    public WebElement filterPreSetCloseBtn;

    @FindBy(id = "loadNextBtn")
    public WebElement showMoreResultBtn;

    @FindBy(xpath = "//input[@id='searchField']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@id='startSearchBtn']")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[@title='Enrol']")
    public WebElement courseEnrolBtn;

    @FindBy(xpath = "//div[@class='small reveal dialog-default']")
    public WebElement enrolPopUpDialog;

    @FindBy(xpath = "//button[@title='Cancel']")
    public WebElement enrolCancelBtn;

    @FindBy(xpath = "//span[.='In progress']")
    public WebElement inProgressLabel;

    @FindBy(xpath = "//button[@title='Enrol']")
    public WebElement enrolConfirmBtn;
}
