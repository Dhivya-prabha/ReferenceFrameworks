package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CallCenterSupervisorFinanceSteps {

    @Autowired
    CallCenterSupervisorFinancePage CallCenterSupervisorFinancePage;

    @Then("Verify the FINANCE menu")
    public void verifyTheFINANCEMenu() {
        CallCenterSupervisorFinancePage.checkElementPresence();
    }
}
