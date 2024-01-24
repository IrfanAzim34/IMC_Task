package com.imc.step_definitions;

import com.imc.pages.CataloguePage;
import com.imc.pages.ClassificationsPage;
import com.imc.pages.InternalDashboardPage;
import com.imc.pages.LogInPage;
import com.imc.utils.BrowserUtils;
import com.imc.utils.ConfigurationReader;
import com.imc.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Lmsils_46752_Steps {

    InternalDashboardPage internalDashboard = new InternalDashboardPage();
    ClassificationsPage classificationsPage = new ClassificationsPage();
    LogInPage logInPage = new LogInPage();

    CataloguePage cataloguePage = new CataloguePage();

    @Given("User login as {string} and {string}")
    public void userLoginAsAnd(String username, String password) {

        /**
         * this do-while loop will check login the right page,sometime it will give systemError page or
         * another login page(I don't know what is that page mean), mainly to avoid these two types problem
         */
        String internalDashboardUrl = ConfigurationReader.getProperty("internalDashboardUrl");
        do {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            logInPage.logIn(username, password);
        } while (!Driver.getDriver().getCurrentUrl().equals(internalDashboardUrl));

        internalDashboard.verifyPageLoaded();
    }

    @When("User navigate to dashboard ID 927747")
    public void userNavigateToDashboardID927747() {
        String logInUrl = ConfigurationReader.getProperty("url");
        String path = "/ilp/pages/internal-dashboard.jsf?menuId=1107&locale=en-GB#/?dashboardId=927747";
        String newUrl = logInUrl.substring(0, logInUrl.indexOf("com") + 3).concat(path);
        Driver.getDriver().navigate().to(newUrl);

        classificationsPage.verifyPageLoaded();
    }

    @And("User click Search in catalogue")
    public void userClickSearchInCatalogue() {
        classificationsPage.searchInCatalogueBtn.click();

        BrowserUtils.waitForElementVisible(cataloguePage.allContents);
    }

    @And("User back to Dashboard use breadcrumb navigate")
    public void userBackToDashboardUseBreadcrumbNavigate() {
        cataloguePage.dashboardBtn.click();

        classificationsPage.verifyPageLoaded();
    }


    @And("User click classification Language skills")
    public void userClickClassificationLanguageSkills() {
        classificationsPage.languageSkillsCard.click();

        cataloguePage.checkFilterPreSet("Language Skills");
        Assert.assertEquals(1, cataloguePage.searchResults.size());
    }

    @And("User remove Language skill filter")
    public void userRemoveLanguageSkillFilter() {
        cataloguePage.filterPreSetCloseBtn.click();

        Assert.assertNotEquals(1, cataloguePage.searchResults.size());
    }

    @And("User click on the MS Office Classification")
    public void userClickOnTheMSOfficeClassification() {
        classificationsPage.msOfficeCard.click();

        cataloguePage.checkFilterPreSet("MS Office");
        Assert.assertFalse(cataloguePage.searchResults.isEmpty());
    }

    @And("User scroll down and click Show more results button")
    public void userScrollDownAndClickShowMoreResultsButton() {
        int initialResultsNum = cataloguePage.searchResults.size();

        BrowserUtils.scrollDownToElement(cataloguePage.showMoreResultBtn);

        cataloguePage.showMoreResultBtn.click();

        BrowserUtils.threadWait(3);

        Assert.assertTrue(cataloguePage.searchResults.size() > initialResultsNum);
    }

    @Then("User Log out")
    public void userLogOut() {
        cataloguePage.logOut();
    }
}
