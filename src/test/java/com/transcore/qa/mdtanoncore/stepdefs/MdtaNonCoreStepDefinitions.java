package com.transcore.qa.mdtanoncore.stepdefs;


import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class MdtaNonCoreStepDefinitions {

    @Autowired
    BasePage basePage;

    @Autowired
    LoginPage loginPage;

    @Autowired
    RetailerDriveezmdLoginPage retailerDriveezmdLoginPage;

    @Autowired
    DashBoardPage dashBoardPage;

    @Autowired
    Environment environment;

    @Value("${integrity.url}")
    String integrityUrl;

    @Value("${retailer.driveezmd.url}")
    String retailerDriveezmdUrl;

    @Value("${staging.driveezmd.url}")
    String stagingDriveezmdUrl;

    @Value("${integrity.username}")
    String integrityUsername;

    @Value("${integrity.password}")
    String integrityPassword;

    @Given("MDTA Integrity application")
    public void mdtaIntegrityApplication() {
        basePage.openBrowser(integrityUrl);
    }

    @Given("Maryland Retailer application")
    public void marylandRetailerApplication() {
        basePage.openBrowser(retailerDriveezmdUrl);
    }

    @Given("MDTA staging application")
    public void mdtaStagingApplication() {
        basePage.openBrowser(stagingDriveezmdUrl);
    }

    @When("a valid User logs in with valid credentials")
    public void aValidUserLogsInWithValidCredentials() {
        loginPage.loginUser(integrityUsername, integrityPassword);
    }

    @Then("Home page should display")
    public void homePageShouldDisplay() {
        basePage.checkElementPresence(dashBoardPage.sideNavSlideout);
    }

    @After
    public void tearDown(){
        basePage.quitDriver();
    }

    @When("a valid User logs in with {string} credentials")
    public void aValidUserLogsInWithCredentials(String role) {
        integrityUsername = environment.getProperty(role+".username");
        integrityPassword = environment.getProperty(role+".password");
        loginPage.loginUser(integrityUsername, integrityPassword);
    }
    @When("a valid retailer driveezmd User logs in with {string} credentials")
    public void aValidDriveezmdUserLogsInWithCredentials(String role) {
        integrityUsername = environment.getProperty(role+".username");
        integrityPassword = environment.getProperty(role+".password");
        retailerDriveezmdLoginPage.loginUser(integrityUsername, integrityPassword);
    }
}
