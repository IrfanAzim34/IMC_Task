package com.imc.pages;

import com.imc.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logIn(String username, String password) {
        this.usernameBox.sendKeys(username);
        this.passwordBox.sendKeys(password);
        this.logInBtn.click();
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInBtn;

}
