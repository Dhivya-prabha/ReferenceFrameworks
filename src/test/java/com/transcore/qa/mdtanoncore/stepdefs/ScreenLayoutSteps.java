package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScreenLayoutSteps {

    @Autowired
    BasePage basePage;

    @Autowired
    DashBoardPage dashBoardPage;

    @Autowired
    ReportsPage reportsPage;

    @Autowired
    AccountPage accountPage;

    @Autowired
    UnpaidPage unpaidPage;

    @When("User click on hamburger menu")
    public void clickOnHamburgerMenu() {
        dashBoardPage.clickHamburgerMenu();
    }

    @Then("hamburger menu should display")
    public void checkHamburgerMenuDisplay() {
        dashBoardPage.checkHamburgerMenuDisplay();
    }

    @Then("{string} should be available in menu")
    public void menuElementShouldBeAvailable(String elementText) { basePage.checkMenuElementDisplay(elementText); }

    @Then("{string} should not be available in menu")
    public void menuElementShouldNotBeAvailable(String elementText) { basePage.checkMenuElementNotDisplay(elementText); }

    @Then("{string} link should be available")
    public void anchorElementShouldBeAvailable(String elementText) { basePage.checkLinkDisplay(elementText); }

    @When("User click on {string} menu option")
    public void clickOnMenuOption(String elementText) {
        basePage.clickMenuElement(elementText);
    }

    @When("User search for an account ID {string}")
    public void enterAccountID(String accountID) {
        dashBoardPage.searchAccount(accountID);
    }

    @Then("The account {string} displays")
    public void checkAccountDisplays(String accountNo) { accountPage.checkAccountNumberDisplay(accountNo); }

    @When("User Select Set as Deceased")
    public void clickSetAsDeceasedInAccountActions() { accountPage.clickSetAsDeceased(); }

    @Then("The {string} window displays")
    public void verifyUploadDeathCertificateDisplay(String msg) { accountPage.checkUploadDeathCertificateWindowDisplay(msg); }

    @Then("Unpaid page should display")
    public void verifyUnpaidPageDisplay() { unpaidPage.navToUnpaidPage(); }

    @And("Select Image Certification")
    public void selectImageCertification() { unpaidPage.clickImageCertification(); }

    @And("Image Certification displays with an image to approve or reject")
    public void verifyAcceptAndRejectButtonDisplay() { unpaidPage.checkAcceptAndRejectDisplay(); }

    @And("Verify the Court Hearing tab does not display")
    public void verifyCourtHearingTabDisplay() {  unpaidPage.checkCourtHearingNotDisplay();  }

    @When("Account type page displays")
    public void navToCreateAccountPage() {  accountPage.checkCreateAccountPageDisplay(); }

    @When("User select the account type dropdown")
    public void openAccountTypeDropdown() { accountPage.clickAccountType(); }

    @Then("Private E-ZPass, Business, Hatem A and Non-Revenue options should displays")
    public void verifyAccountTypeOptionsIsDisplayed(DataTable dT) { accountPage.verifyAccountTypeOptions(dT); }

    @When("User click on {string} link")
    public void clickOnLink(String elementText) { basePage.clickLink(elementText); }

    @When("Select 7 days radio button")
    public void select7DaysRadioButton() { reportsPage.selectLast7Days(); }

    @Then("{string} report should be displayed")
    public void textShouldBeDisplayed(String elementText) { reportsPage.checkReportDetails(elementText); }

    @Then("{string} button should be displayed")
    public void buttonShouldBeDisplayed(String buttonText) { basePage.checkButtonElement(buttonText); }

    @When("User select actions dropdown with {string} as status")
    public void clickTransponderActionsDropDown(String columnValue) { accountPage.clickTransponderActionsDropDown(columnValue); }

    @When("User click and goes to accounts {string} page")
    public void clickAndNavigateTo(String tabName) { accountPage.clickAndNavigateToAccountTab(tabName); }

    @Then("Verify the following option should displays as {string}")
    public void verifyAccountTypeOptionsIsDisplayed(String option) { accountPage.verifyTransponderActionsDropDownWithOption(option); }

    @Then("{string} page should display")
    public void verifyUnpaidPageDisplay(String viewPage) { dashBoardPage.navToViewPage(viewPage); }

    @Then("{string} link should not be available")
    public void anchorElementShouldNotBeAvailable(String elementText) { basePage.checkLinkNotDisplay(elementText); }

    @When("Select today date using calendar icon")
    public void selectTodayDate() { reportsPage.selectTodayDate(); }

    @Then("User click on user icon")
    public void clickUserIcon() { dashBoardPage.clickUserIcon(); }

    @Then("End shift should not be displayed")
    public void verifyEndShiftLink() { dashBoardPage.verifyEndShift(); }

    @When("User click on {string} button")
    public void clickOnButton(String buttonText) { basePage.clickButtonElement(buttonText); }

    @Then("Bankruptcy option should be disabled")
    public void bankruptcyShoulldBeDisabled(){ accountPage.checkBankruptcy();}

}
