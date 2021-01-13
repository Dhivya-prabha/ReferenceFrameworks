package com.transcore.qa.mdtanoncore.pages;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class RetailerDriveezmdOrderPage extends BasePage {

    static final String CARD_NUMBER_FRAME = "tokenFrame";
    static final String CARD_NUMBER = "4111111111111111";

    By genericOrderDetailsInput = By.xpath("//label[text()='XXX']/preceding::input[1]");
    By genericDropDownArrow = By.xpath("//span[text()='XXX']/following::div[@class='mat-select-arrow-wrapper'][1]");
    By genericPlaceholderInput = By.xpath("//input[@placeholder='XXX']");
    By genericEnabledElement = By.xpath("//span[contains(text(),'XXX')]/parent::button[not(@disabled='true')]");
    By columnHeader = By.xpath("//button[contains(text(),'XXX')]");
    By columnData = By.xpath("//table/tbody/tr/td[contains(@class,'XXX')]");

    By poNumber = By.xpath("//td[contains(@class,'order-number')]");
    By selectPurchaseOrder = By.xpath("//button/span[text()='Select']");
    By creditCardNumber = By.id("ccnumfield");
    By stateDropDownArrow = By.xpath("//label[text()='State']/preceding::div[@class='mat-select-arrow-wrapper'][1]");
    By paymentConfirmation = By.xpath("//div[text()='Payment Confirmation #:']/following-sibling::strong");
    By cvcCode = By.xpath("//input[contains(@placeholder,'XXX')]");
    By orderDetailsScreen = By.xpath("//strong[text()='ORDER DETAILS']");

    public void checkAllPoNumberDisplay() {
        pollForElement(20, poNumber);
        Assert.assertTrue("The list of PO number is empty", !getElements(poNumber).isEmpty());
    }

    public void clickRetailerOrdersButtons(String text) {
        clickElement(getLocator(genericSpan, text));
    }

    public void checkRetailerPaymentScreenDisplay(String label) {
        checkElementPresence(getLocator(genericH2, label));
    }

    public void selectFirstPurchesOrder() {
        clickElement(selectPurchaseOrder);
    }

    public void enterPaymentAmount() {
        String amountDue = getElement(getLocator(genericOrderDetailsInput, "Amount Due")).getAttribute("value").replace("$", "");
        String paymentAmount = getElement(getLocator(genericOrderDetailsInput, "Payment Amount")).getAttribute("value");
        Assert.assertTrue("Payment and due are not matching Amount", paymentAmount.contains(amountDue));
    }

    public String getInvoiceNumber() {
        return getElement(getLocator(genericOrderDetailsInput, "Invoice Number")).getAttribute("value");
    }

    public String getPurchaseOrderNumber() {
        return getElement(getLocator(genericOrderDetailsInput, "Purchase Order Number")).getAttribute("value");
    }

    public void enterCreditCardInformation(String cardType) {
        LocalDate localDate = LocalDate.now();
        Faker faker = new Faker();
        clickElement(getLocator(genericDropDownArrow, "Card Type"));
        clickElement(getLocator(genericSpan, cardType));
        switchToFrame(CARD_NUMBER_FRAME);
        enterText(creditCardNumber, CARD_NUMBER);
        switchToDefaultContent();
        clickElement(getLocator(genericDropDownArrow, "Exp.Month"));
        clickElement(getLocator(genericSpan, "February (02)"));
        clickElement(getLocator(genericDropDownArrow, "Exp.Year"));
        clickElement(getLocator(genericSpan, DateTimeFormatter.ofPattern("yyyy").format(localDate.plusYears(1))));
        clickElement(getLocator(cvcCode,"CVC Code"));
        waitSeconds(2);
        enterText(getLocator(cvcCode,"CVC Code"), "888");
        enterText(getLocator(genericPlaceholderInput, "Name Printed on the Card"), "Automation");
        enterText(getLocator(genericPlaceholderInput, "Street Address"), faker.address().streetAddress());
        enterText(getLocator(genericPlaceholderInput, "City"), faker.address().city());
        clickElement(stateDropDownArrow);
        clickElement(getLocator(genericSpan, faker.address().state()));
        enterText(getLocator(genericPlaceholderInput, "Postal Code"), faker.address().zipCode());
    }

    public void clickButton(String text) {
        clickElement(getLocator(genericEnabledElement, text));
    }

    public void verifyOrderDetailsScreenDisplayed() {
        checkElementPresence(orderDetailsScreen);
    }

    public void verifyPaymentConfirmationScreen() {
        waitSeconds(10);
        checkElementPresence(paymentConfirmation);
        String text = getElement(paymentConfirmation).getText();
    }

    public String getPaymentDate() {
        return getElement(getLocator(genericOrderDetailsInput, "Payment Date")).getAttribute("value");
    }

    public void sortColumn(String columnName) {
        clickElement(getLocator(columnHeader, columnName));
        waitSeconds(4);
        clickElement(getLocator(columnHeader, columnName));
        waitSeconds(4);
    }

    public String getColumnValue(String columnName) {
        String value = getElement(getLocator(columnData, columnName)).getText().trim();
        log.info("The Column value " + value + " has been fetched", getLocator(columnData, columnName).toString());
        return value;
    }

    public void checkTodaysDate() {
        Assert.assertTrue("The Order Date is not matching with today's date",getElement(getLocator(columnData, "order-date-time")).getText().contains(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now())));
    }

    public void clickColumnValue(String columnName) {
        clickElement(getLocator(columnData, columnName));
    }
}