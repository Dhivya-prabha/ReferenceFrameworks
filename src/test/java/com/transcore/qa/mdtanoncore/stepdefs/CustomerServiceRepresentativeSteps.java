package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.CustomerServiceRepresentativePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceRepresentativeSteps {

    @Autowired
    CustomerServiceRepresentativePage customerServiceRepresentativePage;

    @Then("User click on hamburger")
    public void user_click_on_hamburger() {
        customerServiceRepresentativePage.clickOnHamburger();
    }

    @Then("click on {string} menu")
    public void clickOnUnpaid(String ClickUnpaid) {
        customerServiceRepresentativePage.ClickOnUnpaid(ClickUnpaid);
    }

    @Then("unpaid doesnot display Image Certification")
    public void unpaidDoesnotDisplayImageCertification() {
        customerServiceRepresentativePage.imageReview();
    }

    @And("Validate {string} is not listed")
    public void validateIsNotListed() {
        customerServiceRepresentativePage.checkAccountTypeElementNotDisplay();
    }
}
