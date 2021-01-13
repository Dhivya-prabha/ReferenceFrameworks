package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class ShipmentPage extends BasePage {

    String id;

    By genericCategory = By.xpath("(//label[text()='Category']/following-sibling::md-select)[XXX]");
    By genericDebit = By.xpath("(//label[contains(text(),'Debit')]/following-sibling::input)[XXX]");
    By genericGLCode = By.xpath("(//label[text()='GL Code']/following-sibling::md-select)[XXX]");
    By genericCredit = By.xpath("(//label[contains(text(),'Credit')]/following-sibling::input)[XXX]");
    By genericNewEntryStatusWithStatus = By.xpath("(//span[text()='XXX']/../preceding-sibling::td/a)[last()]");
    By genericJournalEntryReviewStatus = By.xpath("//h2[text()='Review Journal Entry']/following::md-radio-button[@aria-label='XXX']/div");
    By genericOption = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'XXX')]");
    By actionValue = By.xpath("(//div[text()='XXX'])[last()]");
    By shipperType = By.xpath("//span[text()='Complete Shipment']/preceding::span[text()='Shipper'][1]/following::div[contains(text(),'XXX')][1]");
    By serviceLevelType = By.xpath("//span[text()='Complete Shipment']/preceding::span[text()='Service Level'][1]/following::div[contains(text(),'XXX')]");
    By genericShopOrderOption = By.xpath("//md-select-value//div[contains(text(),'XXX')]");

    By lastActionDropdownWithPendingStatus = By.xpath("(//span[text()='Pending']/../preceding-sibling::td//span[text()='Action'])[last()]");
    By lastID = By.xpath("(//span[text()='Pending']/../preceding-sibling::td//a)[last()]");
    By inboundType = By.xpath("//tr/td[3]/span");
    By actionSpan = By.xpath("//tr[1]//span[contains(text(),'Action')]");
    By memo = By.id("txtMemo");
    By journalEntryGroupID = By.id("txtJournalEntryGroupID");
    By searchParameters = By.xpath("//a[text()='Search Parameters']/following::span[text()='Search']");
    By lastPage = By.xpath("//a[@title='Go to the Last Page']/span");
    By processShipmentAction = By.xpath("//a[@ng-click='openOrdersDetail(dataItem)' and starts-with(text(),'R')]/preceding::span[text()='Action'][1]");
    By shipmentDatePicker = By.xpath("//input[@id='dpqretailerShipmentDate']/following::span[@class='k-icon k-i-calendar']");
    By shipmentDateInputField = By.id("dpqretailerShipmentDate");
    By todayDate = By.xpath("//td[@class='k-today k-state-focused']");
    By expectedDeliveryDatePicker = By.xpath("//input[@id='dpqretailerOrderDate']/following::span[@class='k-icon k-i-calendar']");
    By deliveryDate = By.xpath("//td[@class='k-today k-state-focused']/following-sibling::td[XXX]");
    By deliveryDateDInputField = By.id("dpqretailerOrderDate");
    By shipper = By.xpath("//span[text()='Complete Shipment']/preceding::span[text()='Shipper'][1]/following-sibling::span");
    By serviceLevel = By.xpath("//span[text()='Complete Shipment']/preceding::span[text()='Service Level'][1]/following-sibling::span");
    By trackingNumber = By.name("txtqTrackingNumber");
    By poNumberInputField = By.name("txtPurchOrderNumber");
    By invoiceNumberInputField = By.name("txtInvoiceNumber");

    public void validateInboundOnlyOnRMA() {
        pollForElement(60, actionSpan);
        List<WebElement> inboundTypeList = getElements(inboundType);
        for (int i = 0; i < inboundTypeList.size(); i++) {
            Assert.assertEquals("inbound type is not RMA", "RMA", inboundTypeList.get(i).getText());
            Serenity.takeScreenshot();
        }
    }

    public void clickNewJournalEntry(String text) {
        clickElement(getLocator(genericSpan, text));
    }

    public void checkNewJournalEntryModelDisplay(String label) {
        checkElementPresence(getLocator(genericH2, label));
    }

    public void selectCategory(String rowNumber, String option) {
        clickElement(getLocator(genericCategory, rowNumber));
        clickElement(getLocator(genericOption, option));
    }

    public void selectGLCode(String rowNumber, String option) {
        clickElement(getLocator(genericGLCode, rowNumber));
        clickElement(getLocator(genericOption, option));
    }

    public void enterDebit(String rowNumber, String debit) {
        getElement(getLocator(genericDebit, rowNumber)).clear();
        enterText(getLocator(genericDebit, rowNumber), debit);
    }

    public void enterCredit(String rowNumber, String credit) {
        getElement(getLocator(genericCredit, rowNumber)).clear();
        enterText(getLocator(genericCredit, rowNumber), credit);
    }

    public void enterMemo(String memoText) {
        enterText(memo, memoText);
    }

    public void clickSaveOrCancle(String text) {
        clickElementWithJsExecutor(getLocator(genericSpan, text));
    }

    public void checkNewEntryStatus(String status) {
        clickElement(lastPage);
        checkElementPresence(getLocator(genericNewEntryStatusWithStatus, status));
    }

    public void selectNewEntryDropDownOption(String option) {
        clickElement(lastPage);
        clickElement(lastActionDropdownWithPendingStatus);
        id = getElement(lastID).getText();
        clickElement(getLocator(genericDiv, option));
    }

    public void selectJournalEntryReviewStatus(String status) {
        clickElementWithJsExecutor(getLocator(genericJournalEntryReviewStatus, status));
    }

    public void checkJournalEntryRemoved() {
        clickElement(getLocator(genericAnchor, "Search"));
        enterText(journalEntryGroupID, id);
        clickElement(getLocator(searchParameters, "Search"));
        checkElementNotPresent(getLocator(genericAnchor, id));
    }

    public String filterByNumber(String scenarioName) {
        String purchaseOrder = testContextTO.getScenarioPOMap().get(scenarioName);
        clickElement(getLocator(poFilterLink, "Number"));
        enterText(poNumberInput, purchaseOrder);
        clickElement(filterButton);
        return purchaseOrder;
    }

    public void selectActionDropdown(String option) {
        clickElement(processShipmentAction);
        clickElement(getLocator(actionValue, option));
    }

    public void selectShipmentDate() {
        clickElement(shipmentDatePicker);
        clickElement(todayDate);
    }

    public void checkShipmentDateDisplayed() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();
        String today = formatter.format(localDate);
        Assert.assertEquals("The Shipment date is not matching : ", today, getElement(shipmentDateInputField).getAttribute("value"));
    }

    public void selectShipperType(String option) {
        clickElement(shipper);
        clickElement(getLocator(shipperType, option));
    }

    public void selectExpectedDeliveryDate(String days) {
        clickElement(expectedDeliveryDatePicker);
        clickElement(getLocator(deliveryDate, days));
    }

    public void selectServiceLevel(String level) {
        clickElement(serviceLevel);
        clickElement(getLocator(serviceLevelType, level));
    }

    public void checkExpectedDeliveryDate() {
        String actualDate = getElement(deliveryDateDInputField).getAttribute("value");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now().plusDays(2);
        String expected = formatter.format(localDate);
        Assert.assertEquals("The expected deliveryDate is not matching", actualDate, expected);
    }

    public void enterTrackingNumber(String tNumber) {
        clickElement(trackingNumber);
        waitForElement(trackingNumber).sendKeys(tNumber, Keys.TAB);
    }

    public void verifyTrackingNumber(String tNumber) {
        Assert.assertEquals("The tracking number is not matching", getElement(trackingNumber).getAttribute("value").trim(), tNumber);
    }

    public void clickCompleteShipment() {
        clickElement(getLocator(genericSpan, "Complete Shipment"));
    }

    public String getPurchOrderNumberFromInputFiled() {
        return getElement(poNumberInputField).getAttribute("value");
    }

    public String getinvoiceNumberInputField() {
        return getElement(invoiceNumberInputField).getAttribute("value");
    }

    public void checkRetailerProcessOrderSuccessMessgaeDisplayed(String msg) {
        checkElementPresence(getLocator(genericSpan, msg));
    }

    public void verifyGenericShopOrderOption(String option) {
        checkElementPresence(getLocator(genericShopOrderOption, option));
    }
}