package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.CaseManagementPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CaseManagementConfig {

    @Autowired
    CaseManagementPage caseManagementPage;

    @Then("Configuration  page should not display")
    public void configPageShouldNotDisplay() {
        caseManagementPage.setCaseManagement();
    }

}