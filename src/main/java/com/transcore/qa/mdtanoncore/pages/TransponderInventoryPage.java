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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertTrue;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class TransponderInventoryPage extends BasePage {

    String purchaseOrderNum = String.valueOf(new Random().nextInt(9999999));
    String[] validatePOData = {purchaseOrderNum, "1", "0", "Kapsch", "Other", "Interior Mount Transponder", "Warehouse"};
    String tagWithGenericPONumber = "//span[text()='XXX']/parent::td/following-sibling::td[7]/span";
    String genericFirstInitializingActionDropDownOnList = "//span[contains(text(),'Initializing')]/parent::td/preceding-sibling::" +
            "td/span[contains(text(),'Warehouse')]/parent::td/preceding-sibling::td[1]/a[contains(text(),'XXX')]/parent::td/preceding-sibling::td//md-select";
    By genericTransponderNumber = By.xpath("//td/a[contains(text(),'XXX')]");
    String existingPONumber ;
    final String message = "Transponder model is not as expected at row # ";

    By inboundType = By.xpath("//tr/td[3]/span");
    By createTransponderPOLocationDropDown = By.id("ddlLocation");
    By purchaseOrderNumber = By.id("txtPurchaseOrderNumber");
    By createTransponderPOManufacturerDropDown = By.id("ddlTransponderManufacturer");
    By createTransponderPOModelDropDown = By.id("ddlTransponderType");
    By createTransponderPOModelOther = By.id("ddlTransponderType_1");
    By createTransponderPOTypeDropDown = By.id("ddlTransponderModel");
    By createTransponderPOColorDropDown = By.id("ddlTransponderColor");
    By createTransponderPOQuantity = By.id("txtTransponderQuantity");
    By unitPrice = By.id("txtTransponderUnitPrice");
    By newPurchaseOrderSpan = By.xpath("//tr[1]/td/span");
    By newPurchaseOrderRow = By.xpath("//tr/td/span[contains(text(),'" + purchaseOrderNum + "')]");
    By searchTab = By.xpath("//li/a[text()='SEARCH']");
    By searchTabTransponderStatusDropDown = By.xpath("//md-select[@aria-label='Status']");
    By searchTabTransponderSearchButton = By.xpath("//button/span[contains(text(),'Search')]");
    By searchResultsTransponderStatusColumn = By.xpath("//tr/td[8]/span");
    By transponderStatusColumnData = By.xpath("//tr/td[8]/span");
    By searchTabAccountTypeDropDown = By.name("ddlVehicleClass");
    By searchResultsTransponderModelColumn = By.xpath("//tr/td[11]/span");
    By quickSearchNameInput = By.name("txtOCRresult");
    By newlySavedQuickSearch = By.xpath("//div[@ng-repeat='qSearch in quickSearchDataSource']//div[contains(text(),'" + "AutoTest" + purchaseOrderNum + "')]");
    By searchTabTransponderModelDropDown = By.name("ddlAuditReason");
    By newlySavedQuickSearchDeleteButton = By.xpath("//div[contains(text(),'" + "AutoTest" + purchaseOrderNum + "')]/following-sibling::div/button[@aria-label='Delete']/i");
    By actionDropDownWithLocationWareHouse = By.xpath("//span[text()='Warehouse']/parent::td/preceding-sibling::td[8]//md-select");
    By editButton = By.xpath("//body/div[@role='presentation']//md-content//div[text()='Edit']");
    By existingWarehousePOColumn = By.xpath("//span[text()='Warehouse']/parent::td/preceding-sibling::td[7]/span");
    By transponderTagStatusFilterDropDown= By.xpath("//th[@data-field='tagStatus.tagStatus']//span");
    By transponderTagStatusInput = By.id("txtFilter_tagStatus.tagStatus");
    By transponderTagStatusFilterButton = By.id("btnsub_tagStatus.tagStatus");
    By transponderEmployeeNameDropDown = By.id("ddlUsers");
    By transponderLocationDropDown = By.id("ddlTagCSCLocations");
    By existingInitializingWarehousePOColumn = By.xpath("//span[text()='Initializing']/parent::" +
            "td/preceding-sibling::td[7]/span[contains(text(),'Warehouse')]/parent::td/preceding-sibling::td/a");
    By assignTransponder = By.xpath("//body/div[@role='presentation']//div[contains(text(),'Assign Transponder')]");
    By firstTransponderNumberOnList = By.xpath("//tr[1]/td[3]/a");
    By transponderDetailsLabel = By.xpath("//form//label");
    By transponderDetailsInput = By.xpath("//form//input");
    By transponderHistoryLabel = By.xpath("//a[contains(text(),'Transponder History')]/ancestor::md-content//label");
    By transponderHistoryInput = By.xpath("//a[contains(text(),'Transponder History')]/ancestor::md-content//input");
    By transponderHistoryListViewHeader = By.xpath("//a[contains(text(),'Transponder History')]/ancestor::md-content//th");
    By transponderHistoryListViewData = By.xpath("//a[contains(text(),'Transponder History')]/ancestor::md-content//tr/td");
    By locationDropDown = By.id("ddlLocation");
    By ManufacturerDropDown = By.id("ddlTransponderManufacturer");
    By transponderModelDropDown = By.id("ddlTransponderType");
    By transponderModelOther = By.id("ddlTransponderType_1");
    By transponderTypeDropDown = By.id("ddlTransponderModel");
    By transponderColorDropDown = By.id("ddlTransponderColor");
    By transponderQuantity = By.id("txtTransponderQuantity");
    By searchTabTransponderNumberInput = By.xpath("//label[contains(text(),'Transponder Number')]/following-sibling::input");

    public void createTransponderInventoryPurchaseOrder() {
        clickElement(getLocator(genericSpan, "CREATE PURCHASE ORDER"));
        clickElement(locationDropDown);
        clickElement(getLocator(genericDiv, "Warehouse"));
        enterText(purchaseOrderNumber,purchaseOrderNum);
        clickElement(ManufacturerDropDown);
        clickElement(getLocator(genericDiv, "Kapsch"));
        clickElement(transponderModelDropDown);
        clickElement(transponderModelOther);
        clickElement(transponderTypeDropDown);
        clickElement(getLocator(genericDiv, "Interior Mount Transponder"));
        clickElement(transponderColorDropDown);
        clickElement(getLocator(genericDiv, "Blue"));
        enterText(transponderQuantity,"1");
        clickElement(unitPrice);
        enterText(unitPrice,"2");
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "Save"));
    }

    public void validatePurchaseOrderDataDisplays() {
        pollForElement(60, newPurchaseOrderRow);
        List<String> actualList = new ArrayList<>();
        for (int i = 0; i < validatePOData.length; i++) {
            Assert.assertTrue("Wrong data", getElements(newPurchaseOrderSpan).get(i).getText().contains(validatePOData[i]));
            actualList.add(getElements(newPurchaseOrderSpan).get(i).getText());
        }
        Serenity.recordReportData().withTitle("New purchase order details").andContents(String.join(", ", actualList));
    }

    public void searchForTransponderWithCustomerRetainedStatusFromDropdownFilter() {
        clickElement(searchTab);
        clickElement(searchTabTransponderStatusDropDown);
        clickElement(getLocator(genericDiv, "Customer Retained"));
        actionShortCutKeys(Keys.ESCAPE);
        Serenity.takeScreenshot();
        clickElement(searchTabTransponderSearchButton);
    }

    public void SearchResultsDisplayTranspondersWithTheStatusCustomerRetained() {
        pollForElement(30, searchResultsTransponderStatusColumn);
        List<String> transponderStatusColumnList = new ArrayList<>();
        final int[] i = {1};
        getElements(searchResultsTransponderStatusColumn).forEach(ele ->{
            actionMoveToElement(ele);
            Assert.assertEquals(message + (i[0]),"CUSTOMER RETAINED", ele.getText());
            transponderStatusColumnList.add(ele.getText());
            i[0]++;
        });
        Serenity.recordReportData().withTitle("New purchase order details").andContents(String.join(", ",
                transponderStatusColumnList));
        pollForElement(30, searchResultsTransponderModelColumn);
    }

    public void searchForBusinessWithFlexTransponderFromDropDownFilter() {
        clickElement(searchTab);
        clickElement(searchTabAccountTypeDropDown);
        clickElement(getLocator(genericDiv, "Business E-ZPass"));
        actionShortCutKeys(Keys.ESCAPE);
        clickElement(searchTabTransponderModelDropDown);
        clickElement(getLocator(genericDiv, "Flex Transponder"));
        actionShortCutKeys(Keys.ESCAPE);
        Serenity.takeScreenshot();
        clickElement(searchTabTransponderSearchButton);
    }

    public void SearchResultsDisplayTranspondersModelFlex() {
        pollForElement(30, searchResultsTransponderModelColumn);
        final int[] i = {1};
        getElements(searchResultsTransponderModelColumn).forEach(ele ->{
            actionMoveToElement(ele);
            Assert.assertEquals(message + (i[0]),"Flex Transponder", ele.getText());
            i[0]++;
        });
    }

    public void saveQuickSearchAndSelectRefineSearch() {
        clickElement(getLocator(genericSpan, "Save as Quick Search"));
        enterText(quickSearchNameInput, "AutoTest" + purchaseOrderNum);
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "SAVE"));
        waitFor(getElement(getLocator(genericSpan,"Successfully")));
        clickElement(getLocator(genericSpan, "Refine Search"));
    }

    public void searchScreenDisplaysWithTheNewRecordQuickSearch() {
        checkTabDisplay("SEARCH");
        pollForElement(60, newlySavedQuickSearch);
        Assert.assertTrue("Newly saved quick search is not display",
                getElement(newlySavedQuickSearch).isDisplayed());
    }

    public void deleteTheNewRecordQuickSearch() {
        waitForVisibilityToBeClickableByLocator(60, newlySavedQuickSearchDeleteButton);
        clickElementWithJsExecutor(newlySavedQuickSearchDeleteButton);
        waitForVisibilityToBeClickableByLocator(30, getLocator(genericSpan,"OK"));
        clickElement(getLocator(genericSpan,"OK"));
        waitFor(getElement(getLocator(genericSpan,"successfully")));
    }

    public void newRecordShouldNotBeDisplayedInQuickSearchList() {
        waitForInvisibilityByLocator(20, newlySavedQuickSearch);
        Assert.assertTrue("Newly added quick search still displays after delete it", getElements(newlySavedQuickSearch).isEmpty());
    }

    public void clickEditFromActionDropDownNextToPurchaseOrderNumber() {
        existingPONumber= getElements(existingWarehousePOColumn).get(0).getText();
        getElements(actionDropDownWithLocationWareHouse).get(0).click();
        clickElement(editButton);
    }

    public void updateTransponderLocationAndClickSave(String transponderLocation) {
        clickElement(createTransponderPOLocationDropDown);
        clickElement(getLocator(genericDiv, transponderLocation));
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan,"Save"));
    }

    public void successMessageShouldDisplayAndLocationUpdatedTo(String transponderLocation) {
        waitFor(getElement(getLocator(genericSpan,"successfully")));
        String newUpdatedTransponderLocation = tagWithGenericPONumber.replace("XXX",existingPONumber);
        pollForElement(30,By.xpath(newUpdatedTransponderLocation));
        Assert.assertEquals("Location did not updated ",transponderLocation,getElement(By.xpath(newUpdatedTransponderLocation)).getText() );
    }

    public void userSelectTab(String tabName) {
        clickElement(getLocator(genericAnchor, tabName));
    }

    public void filtersStatusByInitializingAndChooseAssignTransponderFromActionDropdown() {
        clickElement(transponderTagStatusFilterDropDown);
        enterText(transponderTagStatusInput,"Initializing");
        clickElement(transponderTagStatusFilterButton);
        pollForElement(30, existingInitializingWarehousePOColumn);
        existingPONumber= getElements(existingInitializingWarehousePOColumn).get(0).getText();
        waitForVisibilityToBeClickableByLocator(30,By.xpath(genericFirstInitializingActionDropDownOnList.replace("XXX",existingPONumber)));
        clickElementWithJsExecutor(By.xpath(genericFirstInitializingActionDropDownOnList.replace("XXX",existingPONumber)));
        clickElement(assignTransponder);
    }

    public void userChooseEmployeeAndLocationFromDropDowns(String employeeName, String transponderLocation) {
        clickElement(transponderEmployeeNameDropDown);
        clickElement(getLocator(genericDiv,employeeName));
        clickElement(transponderLocationDropDown);
        clickElement(getLocator(genericDiv,transponderLocation));
        Serenity.takeScreenshot();
        clickElement(getLocator(genericSpan, "SAVE"));
    }

    public void locationAndAgentAreUpdatedInTheListForThatTransponder(String employeeName, String locationName) {
        String newUpdatedTransponderEmployee = "//a[text()='"+existingPONumber+"']/parent::td/following-sibling::td[2]/span";
        String newUpdatedTransponderLocation = "//a[text()='"+existingPONumber+"']/parent::td/following-sibling::td[1]/span";
        pollForElement(30,By.xpath("//a[text()='"+existingPONumber+"']/parent::td/following-sibling::td[2]/span[contains(text(),'"+employeeName+"')]"));
        Assert.assertEquals("Location did not updated ",employeeName,getElement(By.xpath(newUpdatedTransponderEmployee)).getText() );
        Assert.assertEquals("Location did not updated ",locationName,getElement(By.xpath(newUpdatedTransponderLocation)).getText() );
    }

    public void selectTransponderNumberFromTheListview() {
        clickElement(firstTransponderNumberOnList);
    }

    public void reviewInformationInTheSummaryTab() {
        List<String> transponderDetailsExpectedLabel = Arrays.asList("Purchase Order Number", "Date Received", "Serial Number", "Transponder Number", "Transponder Status"
                , "Location" , "Manufacturer" , "Transponder Model" , "Transponder Type" , "Transponder Color" , "Transponder Class" , "Warranty Period" , "EOL");
        List<WebElement> elementsLabel = getElements(transponderDetailsLabel);
        List<WebElement> elementsInput = getElements(transponderDetailsInput);
        List<String> transponderDetailsListLabel = new ArrayList<>();
        List<String> transponderDetailsListInput = new ArrayList<>();
        for(WebElement webElement : elementsLabel) {
            transponderDetailsListLabel.add(webElement.getAttribute("textContent"));
        }
        for(WebElement webElement : elementsInput) {
            transponderDetailsListInput.add(webElement.getAttribute("value"));
        }
        Serenity.recordReportData().withTitle("Transponder details label list").andContents(String.join(", ", transponderDetailsListLabel));
        Serenity.recordReportData().withTitle("Transponder details input list").andContents(String.join(", ", transponderDetailsListInput));
        assertTrue("Transponder details label list view is not containing all required items",transponderDetailsListLabel.containsAll(transponderDetailsExpectedLabel));
    }

    public void reviewInformationInTheHistoryTabAndCloseWindow() {
        List<WebElement> elementsLabel = getElements(transponderHistoryLabel);
        List<WebElement> elementsInput = getElements(transponderHistoryInput);
        List<WebElement> elementsHeader = getElements(transponderHistoryListViewHeader);
        List<WebElement> elementsData = getElements(transponderHistoryListViewData);
        List<String> transponderHistoryLabel = new ArrayList<>();
        List<String> transponderHistoryInput = new ArrayList<>();
        List<String> transponderHistoryHeader = new ArrayList<>();
        List<String> transponderHistoryData = new ArrayList<>();
        List<String> transponderHistoryLabelDetailsExpectedLabel = Arrays.asList("Manufacturer", "Type", "Warranty Remaining (Months)",
                "Number","Warranty End Date" );
        List<String> transponderHistoryListviewHeaderDetailsExpected = Arrays.asList("Date/Time", "Location", "Account Type",
                "Account Number","Status", "Reason" ,"Class" ,"Last Changed By");
        elementsLabel.forEach(e -> transponderHistoryLabel.add(e.getAttribute("textContent")));
        elementsInput.forEach(e -> transponderHistoryInput.add(e.getAttribute("value")));
        elementsHeader.forEach(e -> transponderHistoryHeader.add(e.getAttribute("textContent")));
        elementsData.forEach(e -> transponderHistoryData.add(e.getAttribute("textContent")));
        Serenity.recordReportData().withTitle("Transponder details label list").andContents(String.join(", ", transponderHistoryLabel));
        Serenity.recordReportData().withTitle("Transponder details input list").andContents(String.join(", ", transponderHistoryInput));
        Serenity.recordReportData().withTitle("Transponder history header").andContents(String.join(", ", transponderHistoryHeader));
        Serenity.recordReportData().withTitle("Transponder history data").andContents(String.join(", ", transponderHistoryData));
        assertTrue("Transponder history details label list view is not containing all required items",transponderHistoryLabel.containsAll(transponderHistoryLabelDetailsExpectedLabel));
        assertTrue("Transponder history list view header is not containing all required items",transponderHistoryHeader.containsAll(transponderHistoryListviewHeaderDetailsExpected));
    }
}