package com.imc.pages;

import com.imc.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassificationsPage extends InternalDashboardPage {

    public ClassificationsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void verifyPageLoaded() {
        Assert.assertTrue(classificationPanel.isDisplayed());
        Assert.assertTrue(Driver.getDriver().getTitle().contains("#TD #Classifications"));
    }

    @FindBy(xpath = "//section[@class='classification-search dashboard-panel']")
    public WebElement classificationPanel;

    @FindBy(xpath = "//button[.='Search in catalogue ']")
    public WebElement searchInCatalogueBtn;

    @FindBy(xpath = "//a[.=' Language Skills ']")
    public WebElement languageSkillsCard;

    @FindBy(xpath = "//a[.=' MS Office ']")
    public WebElement msOfficeCard;

}
