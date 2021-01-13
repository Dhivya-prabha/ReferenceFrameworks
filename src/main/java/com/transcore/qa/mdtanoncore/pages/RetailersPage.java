package com.transcore.qa.mdtanoncore.pages;


import com.github.javafaker.Faker;
import com.transcore.qa.mdtanoncore.transferobjects.TestContextTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.*;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class RetailersPage extends BasePage {

    final static String US_LOCALE = "en-US";
    final static String GIANT = "GIANT";
    final static String GIANT_108 = "GIANT #108";
    final static String KAPSCH = "Kapsch";
    final static String PREPAID = "Prepaid";
    final static String AUTO_CONTACT_NAME = "Autouser";
    static String poNumber;

    By ordersTab = By.xpath("//a[contains(text(),'ORDERS')]");
    By retailersDropdown = By.id("ddlRetailer");
    By retailerLocationDropDown = By.id("ddlRetailerLocation");
    By retailerManufacturerDropDown = By.id("ddlRetTransponderManufacturer");
    By retailerTransponderColorDropDown = By.id("ddlRetTransponderColor");
    By retailerTransponderQty = By.id("txtTransponderQty");
    By retailerOrderform = By.id("retailerOrderform");
    By successToast = By.xpath("//div/span[contains(text(),'The Retailer Order was added successfully')]");
    By newRetailerPurchaseOrder = By.xpath("//tr[1]/td/span[text()='" + KAPSCH + "']/parent::td/preceding-sibling::td/span[text()='" + GIANT_108 + "']/parent::td/preceding-sibling" +
            "::td/span[text()='" + GIANT + "']/parent::td/preceding-sibling::td/span[text()='1']/parent::td/preceding-sibling::td[2]/a");
    By retailerNameText = By.xpath("//div[@k-options='retailerGridOptions']//td/span[contains(text(),'XXX')]");
    By actionDropdown = By.xpath("//td/span[contains(text(),'XXX')]/parent::td/preceding-sibling::td//span[contains(text(),'Action')]");
    By historyTab = By.xpath("//span[contains(text(),'HISTORY')]");
    By orderHistoryList = By.xpath("//div[@k-options='retailerHistoryGridOptions']//thead/tr/th//a[@class='k-link']");
    By orderHistoryRetailerName = By.xpath("//div[@k-options='retailerHistoryGridOptions']//tr[@testid='row_0']/td[3]");
    By retailerLocationStreetInput = By.xpath("//input[@id='_textentryprimaryStreetAddress']");
    By retailerLocationListTd = By.xpath("//div[@k-options='locationGridOptions']//div[@class='k-grid-content k-auto-scrollable']//td[2]");
    By transponderColor = By.xpath("//md-option[contains(@id,'ddlRetTransponderColor')]/div[contains(text(),'XXX')]");
    By latestOrderDateTime = By.xpath("//div[@id='ordersGridOptionsId']//tr[1]/td[2]");
    By latestPurchaseOrderNumber = By.xpath("//div[@id='ordersGridOptionsId']//tr[1]/td[1]/a");
    By locationOption = By.xpath("//md-option[1]/div[contains(text(),'GIANT')]");
    By addRetailerButton = By.xpath("//button[@ng-click='openRetailerPopup(detailItem)']");
    By retailerTypeDropdown = By.xpath(" //md-select[@id='Md-select4'] ");
    By retailerBillingDropdown = By.xpath("//md-select[@id='ddlbillingOption']");
    By retailerName = By.name("txtRetailerName");
    By retailerLocationName = By.name("txtLocationName");
    By retailerStreet = By.id("_textentryprimaryStreetAddress");
    By retailerSecondaryStreet = By.id("_textentrysecondaryStreetAddress");
    By retailerCity = By.id("_txtCityname");
    By retailerZipcode = By.id("_zipCodeCtrl");
    By retailerContactName = By.name("txtContactName");
    By retailerContactPhone = By.name("txtContactPhone");
    By retailerContactEmail = By.name("txtContactEmail");
    By retailerTransponderThreshold = By.name("txtThreshold");
    By retailerRestock = By.name("txtRestock");
    By retailerPrepaidTollBalance = By.name("txtTollBalance");
    By retailerDiscount = By.name("txtDiscountPercentage");
    By retailerSaveButton = By.xpath("//span[normalize-space()='SAVE']");
    By retailerSuccessToast = By.xpath("//div/span[contains(text(),'The Retailer was added successfully')]");
    By cancelReason = By.id("txtCancelReason");
    By purchOrderNumber = By.id("txtPurchOrderNumber");
    By firstOrderNumber =  By.xpath("//td[contains(@class,'order-number')]");

    By orderNumberWithStatus = By.xpath("//span[text()='XXX']/../preceding-sibling::td/a[@ng-click='openOrdersDetail(dataItem)']");
    By orderQuantityWithPONumber = By.xpath("//a[text()='XXX']/../following-sibling::td/span[@ng-bind='dataItem.retailerOrderQuantity']");
    By actionDropdownWithStatus = By.xpath("(//span[text()='XXX']/../preceding-sibling::td//label[text()='Action']/following::md-select)[1]");
    By transponderQuantity = By.xpath("//input[@placeholder='Transponder Quantity']");

    @Autowired
    TestContextTO testContextTO;

    Map<String, String> retailerDetails = new HashMap<>();

    public void createRetailer() {
        String retailerNameValue = "Psquareretailer" + (new Random().nextInt((999 - 200) + 1) + 200);
        clickElement(addRetailerButton);
        clickElement(retailerTypeDropdown);
        clickElement(getLocator(genericDiv, "Giant"));
        clickElement(retailerBillingDropdown);
        clickElement(getLocator(genericDiv, PREPAID));
        enterText(retailerName, retailerNameValue);
        enterText(retailerLocationName, "Psquare");
        enterText(retailerStreet, "Street");
        enterText(retailerSecondaryStreet, "Secondarystreet");
        enterText(retailerCity, "City");
        enterText(retailerZipcode, "10001");
        enterText(retailerContactName, "Psquareauto");
        enterText(retailerContactPhone, "0000000000");
        enterText(retailerContactEmail, "Psquareauto@mailinator.com");
        enterText(retailerTransponderThreshold, "10");
        enterText(retailerRestock, "10");
        enterText(retailerPrepaidTollBalance, "20");
        enterText(retailerDiscount, "20");
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "SAVE"));
    }

    public void createRetailerPurchaseOrder(Map<String, String> transponderDetails) {
        clickElement(retailersDropdown);
        clickElement(getLocator(genericDiv, GIANT));
        clickElement(retailerLocationDropDown);
        clickElement(getLocator(genericDiv, GIANT_108));
        clickElement(retailerManufacturerDropDown);
        clickElement(getLocator(genericDiv, KAPSCH));
        clickElement(retailerTransponderColorDropDown);
        clickElement(getLocator(transponderColor, transponderDetails.get("color")));
        enterText(retailerTransponderQty, transponderDetails.get("quantity"));
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "Save"));
    }

    public void reviewPurchaseOrder(String scenarioName) {
        By latestPurchaseOrder = getLatestPurchaseOrder();
        testContextTO.getScenarioPOMap().put(scenarioName, find(latestPurchaseOrder).getText());
        clickElement(latestPurchaseOrder);
        waitForElement(20, retailerOrderform);
    }

    public void validateSuccessMessageAndReviewPurchaseOrder() {
        waitForElement(successToast);
        clickElement(newRetailerPurchaseOrder);
        waitForElement(20, retailerOrderform);
    }

    private By getLatestPurchaseOrder() {
        waitSeconds(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.parse(LocalDateTime.now().format(formatter));
        LocalDateTime lowerDateTime = currentDateTime.minusSeconds(40);
        LocalDateTime upperDateTime = currentDateTime.plusSeconds(20);

        String orderDateTimeStr = waitForElement(latestOrderDateTime).getText();
        LocalDateTime orderDateTime = LocalDateTime.parse(orderDateTimeStr, formatter1);
        if (orderDateTime.isAfter(lowerDateTime) && orderDateTime.isBefore(upperDateTime)) {
            return latestPurchaseOrderNumber;
        } else {
            fail("Latest purchase order is not displayed in the list");
        }
        return null;
    }

    public void chooseEditInActionOfRetailer(String retailerName) {
        clickElement(getLocator(actionDropdown, retailerName));
        clickElement(getLocator(actionOptions, "Edit"));
    }

    public void clickOnRetailer(String retailerName) {
        clickElement(getLocator(retailerNameText, retailerName));
    }

    public void clickOnHistory() {
        clickElement(historyTab);
    }

    public void validateOrderHistoryListView(String retailer) {
        List<String> orderHistoryExpectedList = Arrays.asList("Order Date/Time", "Quantity", "Retailer", "Retailer Location", "Manufacturer", "Type");
        List<WebElement> elements = getElements(orderHistoryList);
        List<String> orderHistoryList = new ArrayList<>();
        for (WebElement webElement : elements) {
            orderHistoryList.add(webElement.getAttribute("textContent"));
        }
        Serenity.recordReportData().withTitle("Order History List").andContents(String.join(", ", orderHistoryList));
        assertTrue("Order History list view is not containing all required items", orderHistoryList.containsAll(orderHistoryExpectedList));
        assertEquals("Retailer name in the order history is not " + retailer, retailer, getElement(orderHistoryRetailerName).getText());
    }

    public String enterRetailerLocationDetailsAndSave() {
        Faker faker = new Faker(new Locale(US_LOCALE));
        String location = faker.address().city();
        enterText(getLocator(genericLabelInput, "Location Name"), location);
        enterText(retailerLocationStreetInput, faker.address().streetAddress());
        enterText(getLocator(genericLabelInput, "City"), location);
        enterText(getLocator(genericLabelInput, "Zip Code"), faker.address().zipCodeByState(STATE_CODE));
        enterText(getLocator(genericLabelInput, "Contact Name"), AUTO_CONTACT_NAME);
        enterText(getLocator(genericLabelInput, "Contact Phone"), getRandomPhone());
        enterText(getLocator(genericLabelInput, "Contact Email"), AUTO_CONTACT_NAME.concat("@yopmail.com"));
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "SAVE"));
        return location;
    }

    public void validateUpdatedRetailerLocationList(String retailerLocation) {
        boolean locationFound = false;
        List<WebElement> elements = getElements(retailerLocationListTd);
        for (WebElement webElement : elements) {
            if (retailerLocation.equals(webElement.getAttribute("textContent"))) {
                locationFound = true;
                break;
            }
        }
        Serenity.recordReportData().withTitle("Newly Added Retailer Location").andContents(retailerLocation);
        Serenity.takeScreenshot();
        assertTrue("Retailer Locations list is not having " + retailerLocation, locationFound);
        clickElement(getLocator(actionDropdown, "Autouser"));
        clickElement(getLocator(actionOptions, "Deactivate"));
        clickElement(getLocator(genericSpan, "OK"));
        waitForElement(10, toastDiv);
    }

    public String createNewRetailerUserDetails() {
        String firstName = "Auto" + getRandomName("FIRST");
        String userName = firstName + (new Random().nextInt((99 - 10) + 1) + 10);
        enterText(getLocator(genericLabelInput, "First Name"), firstName);
        enterText(getLocator(genericLabelInput, "User Name"), userName);
        enterText(getLocator(genericLabelInput, "Last Name"), "Auto" + getRandomName("LAST"));
        enterText(getLocator(genericLabelInput, "Email Address"), userName + "@yopmail.com");
        clickElement(getLocator(genericLabelDropdown, "Organization"));
        clickElement(getLocator(genericDropdownOption, GIANT));
        clickElement(getLocator(genericLabelDropdown, "Location"));
        clickElement(locationOption);
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "SAVE"));
        return firstName;
    }

    public void validateSuccessMessageForRetailerAdding() {
        waitForElement(retailerSuccessToast);
    }

    public void validateUpdatedRetailerUsersList(String retailer) {
        Serenity.recordReportData().withTitle("Newly Added Retailer User").andContents(retailer);
        checkElementPresence(getLocator(genericSpan, retailer));
        clickElement(getLocator(actionDropdown, retailer));
        clickElement(getLocator(actionOptions, "Deactivate"));
        validateToastMessage("User has been updated successfully");
    }

    public void selectOrdersWithActiveRequest(String status) {
        poNumber = getElement(getLocator(orderNumberWithStatus, status)).getText();
        clickElement(getLocator(orderNumberWithStatus, status));
    }

    public void checkOrderDetailsDisplay(String orderDetails) {
        checkElementPresence(getLocator(genericH2, orderDetails));
    }

    public void UpdateTransponderQuantity(String quantity) {
        clickElement(retailerTransponderQty);
        getElement(retailerTransponderQty).clear();
        enterText(retailerTransponderQty, quantity);
        clickElement(getLocator(genericSpan, "Save"));
    }

    public void checkOrderDetailsUpdated(String quantity) {
        checkElementPresence(getLocator(orderQuantityWithPONumber, poNumber));
        Assert.assertEquals("Order Details not Updated", getElement(getLocator(orderQuantityWithPONumber, poNumber)).getText(), quantity);
    }

    public void selectActionDropdownWithStatus(String status) {
        clickElement(getLocator(actionDropdownWithStatus, status));
    }

    public void verifyOptionsOfActionDropdown(String option1, String option2) {
        checkElementPresence(getLocator(genericDiv, option1));
        checkElementPresence(getLocator(genericDiv, option2));
    }

    public void selectActionDropdown(String option) {
        clickElement(getLocator(genericDiv, option));
    }

    public void enterReasonAndSave(String reason) {
        poNumber = getElement(purchOrderNumber).getAttribute("value");
        enterText(cancelReason, reason);
        clickElementWithJsExecutor(getLocator(genericSpan, "Save"));
    }

    public void verifyOrderRemoved() {
        checkElementPresence(getLocator(genericSpan, "The Order has been successfully Cancelled"));
        checkElementNotPresent(getLocator(genericAnchor, poNumber));
    }

    public void updateRetailersDetails() {
        retailerDetails.put("transponderThreshold", getElement(getLocator(genericLabelInput, "Transponder Threshold")).getAttribute("value"));
        retailerDetails.put("restockRecommendation", getElement(getLocator(genericLabelInput, "Restock Recommendation")).getAttribute("value"));
        retailerDetails.put("prepaidTollBalance", getElement(getLocator(genericLabelInput, "Prepaid Toll Balance")).getAttribute("value"));

        enterText(getLocator(genericLabelInput, "Transponder Threshold"), "150");
        enterText(getLocator(genericLabelInput, "Restock Recommendation"), "100");
        enterText(getLocator(genericLabelInput, "Prepaid Toll Balance"), "30");
        clickElement(getLocator(genericButton, "SAVE"));
    }

    public void revertRetailersDetails(String retailerName) {
        clickElement(getLocator(actionDropdown, retailerName));
        clickElement(getLocator(actionOptions, "Edit"));

        enterText(getLocator(genericLabelInput, "Transponder Threshold"), retailerDetails.get("transponderThreshold"));
        enterText(getLocator(genericLabelInput, "Restock Recommendation"), retailerDetails.get("restockRecommendation"));
        enterText(getLocator(genericLabelInput, "Prepaid Toll Balance"), retailerDetails.get("prepaidTollBalance"));
        clickElement(getLocator(genericButton, "SAVE"));
    }

    public void enterTransponderQuantity(String tQuantity){
        enterText(transponderQuantity,tQuantity);
    }

    public void clickColumnValue(String columnName){
        clickElement(getLocator(firstOrderNumber,columnName));
    }
}