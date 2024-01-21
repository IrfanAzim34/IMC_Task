package com.imc.pages;

import com.imc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClientsPage extends InternalDashboardPage {

    public ClientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @Override
    public void verifyPageLoaded() {
        Assert.assertTrue(this.contentFrame.isDisplayed());
    }

    public void searchResult(String searchTerm) {
        this.searchBox.sendKeys(searchTerm);
        this.startSearchBtn.click();
    }

    public void globalEdit() {
        this.clientEditBtn.click();
        this.globalEditBtn.click();
    }

    @FindBy(xpath = "//iframe[@name='contentframe']")
    public WebElement contentFrame;

    @FindBy(xpath = "//iframe[@name='iframe_navi:1243']")
    public WebElement subframeOfContentFrame;

    @FindBy(xpath = "//input[@id='searchTerm-inputEl']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@id='startSearchButton']")
    public WebElement startSearchBtn;

    @FindBy(xpath = "//tbody[@id='imcgridview-1045-body']/tr/td[2]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//a[@id='tbb_editGroup']")
    public WebElement clientEditBtn;

    @FindBy(xpath = "//a[@id='tbi_edit_global-itemEl']")
    public WebElement globalEditBtn;

}
