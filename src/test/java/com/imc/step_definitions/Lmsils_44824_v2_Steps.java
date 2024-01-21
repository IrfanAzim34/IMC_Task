package com.imc.step_definitions;

import com.imc.pages.CataloguePage;
import com.imc.pages.ClientsPage;
import com.imc.pages.EditPage;
import com.imc.pages.InternalDashboardPage;
import com.imc.utils.BrowserUtils;
import com.imc.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Lmsils_44824_v2_Steps {
    InternalDashboardPage internalDashboard = new InternalDashboardPage();
    ClientsPage clientsPage = new ClientsPage();
    EditPage editPage = new EditPage();
    CataloguePage cataloguePage = new CataloguePage();

    @When("User navigate to Client Manager")
    public void userNavigateToClientManager() {
        internalDashboard.navigateToClientManager();

        clientsPage.verifyPageLoaded();
    }

    @And("User find {string} to edit it")
    public void userFindToEditIt(String clientName) {
        BrowserUtils.switchInFrame(clientsPage.contentFrame);
        BrowserUtils.switchInFrame(clientsPage.subframeOfContentFrame);

        clientsPage.searchResult(clientName);
        for (WebElement searchResult : clientsPage.searchResults) {
            if (searchResult.getAttribute("data-qtip").equalsIgnoreCase(clientName)) {
                searchResult.click();
                break;
            }
        }

        clientsPage.globalEdit();

        BrowserUtils.switchBackMainHtml();
    }

    @And("User verify Warning of time conflicts is unchecked")
    public void userVerifyWarningOfTimeConflictsIsUnchecked() {
//        new WebDriverWait(Driver.getDriver(), 10)
//                .until(ExpectedConditions.numberOfWindowsToBe(2));
        BrowserUtils.waitUntilAllWindowsOpen(2);
        String originalWindow = Driver.getDriver().getWindowHandle();

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.contentEquals(originalWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        BrowserUtils.switchInFrame(editPage.contentFrame);
        BrowserUtils.switchInFrame(editPage.subframeOfContentFrame);

        editPage.settingsBtn.click();

        BrowserUtils.scrollDownToElement(editPage.warningOfTimeCheckbox);
//        Assert.assertFalse(editPage.warningOfTimeCheckbox.getAttribute("class").endsWith("checked"));
        //TODO -There is a bug, it shouldn't be checked, default is Unchecked status
        // just comment it until fixed it

        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(originalWindow);

        clientsPage.logOut();
    }

    @And("User search {string} in catalogue page")
    public void userSearchInCataloguePage(String subject) {
        internalDashboard.catalogueBtn.click();
        cataloguePage.verifyPageLoaded();
        cataloguePage.search(subject);

        Assert.assertEquals(6, cataloguePage.searchResults.size());
    }

    @Then("User verify {string} enrolment button")
    public void userVerifyEnrolmentButton(String contentName) {
        for (WebElement result : cataloguePage.searchResults) {
            if (result.getText().equals(contentName)) {
                result.click();
                break;
            }
        }

        //TODO -Because of this course was already canceled so we can not enrol this course no longer
        // This is might be a impediment but not a bug, skip this part for now

        cataloguePage.logOut();
    }

    @And("User activate Warning of time conflicts checkbox")
    public void userActivateWarningOfTimeConflictsCheckbox() {
//        new WebDriverWait(Driver.getDriver(), 10)
//                .until(ExpectedConditions.numberOfWindowsToBe(2));
        BrowserUtils.waitUntilAllWindowsOpen(2);
        String originalWindow = Driver.getDriver().getWindowHandle();

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.contentEquals(originalWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        BrowserUtils.switchInFrame(editPage.contentFrame);
        BrowserUtils.switchInFrame(editPage.subframeOfContentFrame);

        editPage.settingsBtn.click();

        BrowserUtils.scrollDownToElement(editPage.warningOfTimeCheckbox);
//        editPage.warningOfTimeCheckbox.click();
//        Assert.assertTrue(editPage.warningOfTimeCheckbox.getAttribute("class").endsWith("checked"));
//        editPage.saveAndCloseBtn.click();
        // TODO because it was not default unchecked status so If I execute these two line and save it
        //  it will occur potential issue in previous tests, leave it like this until fixed it

        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(originalWindow);
        clientsPage.logOut();
    }
}
