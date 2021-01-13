package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class DriveezmdStagingSteps {

    @Autowired
    StagingDriveezmdHomePage stagingDriveezmdHomePage;

    @Autowired
    StagingDriveezmdOnTheGoPage stagingDriveezmdOnTheGoPage;


    @When("User click {string} from menu item")
    public void userClicksMenuItem(String menu) {
        stagingDriveezmdHomePage.navigateMenuItem(menu);
    }

    @Then("User clicks on {string} link")
    public void userClick(String text) {
        stagingDriveezmdOnTheGoPage.clickOnLink(text);
    }

    @Then("Verify home screen displayed")
    public void userCheckHomeScreenDisplay() {
        stagingDriveezmdHomePage.checkHomeScreenDisplay();
    }
}