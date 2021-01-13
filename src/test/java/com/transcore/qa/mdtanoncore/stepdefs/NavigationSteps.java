package com.transcore.qa.mdtanoncore.stepdefs;


import com.transcore.qa.mdtanoncore.pages.BasePage;
import com.transcore.qa.mdtanoncore.pages.DashBoardPage;
import com.transcore.qa.mdtanoncore.pages.SystemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import static com.transcore.qa.mdtanoncore.pages.SystemPage.myPrefencelang;
import static com.transcore.qa.mdtanoncore.pages.SystemPage.theme;

public class NavigationSteps   {

    @Autowired
    DashBoardPage dashBoardPage;

    @Autowired
    BasePage basePage;

    @Autowired
    SystemPage systemPage;

    @Then("Home page contains different tabs")
    public void homePageContainsDifferentTabs() {
        dashBoardPage.dasboardTabVisibility();
    }

    @When("click on hamburger")
    public void click_on_hamburger() {
        dashBoardPage.hamburgerClick();
    }

    @When("click on left pointing arrow")
    public void clickOnLeftPointingArrow() {
        dashBoardPage.hamburgerClickSlidein();
    }

    @Then("Click on System down arrow")
    public void click_on_System_down_arrow() {
        systemPage.systemDownArrow(); }

    @Then("Click on EndShift popup Cancel")
    public void clickOnEndShiftPopupCancel() {
        systemPage.endShiftClose();
    }

    @Then("Click on ChangePassword")
    public void click_on_ChangePassword() {
        systemPage.changePassword();
    }

    @Then("Click on My Preferences")
    public void click_on_My_Preferences() {
        systemPage.myPreference();
    }

    @Then("Click on Logout")
    public void click_on_Logout() {
        basePage.logOut();
    }

    @Then("Pop shown for Logout")
    public void popShownForLogout() {
        systemPage.logoutPopup();
    }

    @Then("Redirect to Login Page")
    public void redirectToLoginPage() {
        systemPage.returnToLogin();
    }

    @Then("Validate the Home Page with role-specific dashboard choices in the Tab")
    public void validateTheHomePageWithRoleSpecificDashboardChoicesInTheTab() {
        dashBoardPage.dasboardTabVisibility();
    }

    @When("Click on EndShift link")
    public void clickOnEndShiftLink() {
        systemPage.endShift();
    }

    @Then("Validate Main Menu items displayed")
    public void validateMainMenuItemsDisplayed() {
        dashBoardPage.mainMenuVisibility();
    }

    @Then("Validate menus Under Configuration")
    public void validateMenusUnderConfiguration() {
        dashBoardPage.configurationSubMenuVisibility();
    }

    @Then("User Menu displays")
    public void userMenuDisplays() {
        dashBoardPage.systemDownArrowSubMenu();
    }

    @Then("Validate Main menu items should be hidden")
    public void validateMainMenuItemsShouldBeHidden() {
        dashBoardPage.verfiyMenuHidden();
    }

    @Then("Click on {string}")
    public void clickOn(String clickElementName) {
        dashBoardPage.clickElementWithPtag(clickElementName);
    }

    @Then("Validate {string} pop-up Modal Window displayed")
    public void validatePopUpModalWindowDisplayed(String window) {
       basePage.checkWindowDisplay(window);
    }

    @And("Validate required fields underlined in red in Add Location")
    public void validateRequiredFieldsUnderlinedInRedInAddLocation() {
        By verifyRequiredFields =By.xpath("//md-input-container[contains (@class,'required') and  not(contains(@class,' md-input-has-value'))]");
        basePage.checkElementPresence(verifyRequiredFields);
    }

    @When("Click on {string} button")
    public void clickOnButton(String buttonName) {
        basePage.clickElement(buttonName);
    }

    @And("Validate it  displays with Language and Theme choices")
    public void validateItDisplaysWithLanguageAndThemeChoices() {
        systemPage.checkElementPresence( myPrefencelang);
        systemPage.checkElementPresence(theme);
    }

    @When("Click on Close button")
    public void clickOnCloseButton() {
        systemPage.endShiftClose();
    }

    @Then("Validate {string} tab")
    public void validateTab(String tabName) {
        systemPage.tabNameDisplays(tabName);
    }

    @When("User enter Password {string}")
    public void userEnterPassword(String password) {
        systemPage.enterPassword(password);
    }

    @When("User enter Check amount {string}")
    public void userEnterCheckAmount(String checkAmount) {
        systemPage.endShiftAmount(checkAmount);
    }

    @Then("Agency Location Window Displays")
    public void agencyLocationWindowDisplays() {
        dashBoardPage.verifyAgencyLoc();
    }
}

