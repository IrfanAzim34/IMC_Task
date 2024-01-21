package com.imc.pages;

import com.imc.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
    public EditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//iframe[@name='contentframe']")
    public WebElement contentFrame;

    @FindBy(xpath = "//iframe[@name='iframe_edit.200.1']")
    public WebElement subframeOfContentFrame;

    @FindBy(xpath = "//div[@id='tabPanel']//a[4]")
    public WebElement settingsBtn;

    @FindBy(xpath = "//table[@id='enrollment.warningForTimeConflicts']")
    public WebElement warningOfTimeCheckbox;

    @FindBy(xpath = "//a[@id='default_saveClose']")
    public WebElement saveAndCloseBtn;
}
