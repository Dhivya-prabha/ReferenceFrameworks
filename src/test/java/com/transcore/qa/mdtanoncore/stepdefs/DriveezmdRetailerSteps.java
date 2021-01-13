package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class DriveezmdRetailerSteps {

    @Autowired
    BasePage basePage;

    @Autowired
    RetailerDriveezmdOrderPage orderPage;

    @Autowired
    RetailerDriveezmdDashBoardPage dashBoardPage;

    @Autowired
    RetailerDriveezmdLoginPage loginPage;

    @Autowired
    RetailerDriveezmdPaymentPage paymentPage;

    String invoiceNumber;
    String purchaseOrderNumber;
    String paymentDate;
    String columnValue;

    @When("User click on hamburger menu in driveezmd Pages")
    public void clickOnHamburgerMenu() {
        dashBoardPage.clickHamburgerMenu();
    }

    @When("User click on hamburger goes to {string} in driveezmd Pages")
    public void userClickOnHamburgerGoesToInDriveezmdPages(String retailerPages) {
        dashBoardPage.navToRetailerPages(retailerPages);
    }

    @When("Validate All PoNumber is Displayed")
    public void userCheckAllPoNumberDisplay() {
        orderPage.checkAllPoNumberDisplay();
    }

    @When("User click {string} button")
    public void userClickRetailerPayment(String button) {
        orderPage.clickRetailerOrdersButtons(button);
    }

    @Then("Validate {string} Screen Display")
    public void ValidateRetailerPaymentScreenDisplay(String title) {
        orderPage.checkRetailerPaymentScreenDisplay(title);
    }

    @Then("Verify payments page displayed")
    public void verifyPaymentsPageIsDisplayed() {
        paymentPage.verifyPaymentsPageDisplayed();
    }

    @When("User click first purches order selete button")
    public void userClickFirstPurchesOrderSeleteButton() {
        orderPage.selectFirstPurchesOrder();
    }

    @Then("Verify order details screen displayed")
    public void verifyOrderDetailsScreenDisplayed() {
        orderPage.verifyOrderDetailsScreenDisplayed();
    }

    @Then("User enter the amount to be paid in order details")
    public void UserEnterAmountToBePaid() {
        orderPage.enterPaymentAmount();
    }

    @And("user get invoice and purchase Order Number")
    public void userSelectPurchaseOrderToReview() {
        invoiceNumber = orderPage.getInvoiceNumber();
        purchaseOrderNumber = orderPage.getPurchaseOrderNumber();
    }

    @Then("User enter {string} Card")
    public void userEnterCreditCardInformation(String cardType) {
        orderPage.enterCreditCardInformation(cardType);
    }

    @Then("User click {string} on button")
    public void userClickButton(String buttonName) {
        orderPage.clickButton(buttonName);
    }

    @Then("Verify Payment Confirmation Screen Displayed")
    public void userVerifyPaymentConfirmationScreen() {
        orderPage.verifyPaymentConfirmationScreen();
        paymentDate = orderPage.getPaymentDate();
    }

    @When("User sort the Date Column")
    public void userSortDateColumn() {
        paymentPage.sortDateColumn();
    }

    @Then("Verify the payment displays")
    public void searchScreenDisplaysWithTheNewRecordQuickSearch() {
        paymentPage.checkInvoiceNumber(invoiceNumber);
    }

    @When("User sort the {string} Column")
    public void genericColumnSort(String columnName) {
        orderPage.sortColumn(columnName);
    }

    @Then("Verify the column {string} value displayed")
    public void userGetColumnData(String text) {
        columnValue = orderPage.getColumnValue(text);
    }

    @Then("Verify order date for the first PO number")
    public void verifyOrderDate() {
        orderPage.checkTodaysDate();
    }

    @Then("User clicks the column value with {string}")
    public void userClick(String text) {
        orderPage.clickColumnValue(text);
    }

    @Then("Verify retailer login screen displayed")
    public void userCheckRetailerLoginScreenDisplay() {
        loginPage.checkRetailerLoginScreenDisplayed();
    }
}