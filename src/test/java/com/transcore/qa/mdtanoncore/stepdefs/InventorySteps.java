package com.transcore.qa.mdtanoncore.stepdefs;

import com.transcore.qa.mdtanoncore.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class InventorySteps {

    @Autowired
    BasePage basePage;

    @Autowired
    DashBoardPage dashBoardPage;

    @Autowired
    ShipmentPage shipmentPage;

    @Autowired
    TransponderInventoryPage transponderInventoryPage;

    @Autowired
    RetailersPage retailersPage;

    @Autowired
    AccountPage accountPage;

    @Autowired
    FulfillmentPage fulfillmentPage;

    @Autowired
    StagingDriveezmdHomePage stagingDriveezmdHomePage;

    @Autowired
    StagingDriveezmdOnTheGoPage stagingDriveezmdOnTheGoPage;

    String retailer;
    String retailerLocation;
    String purchaseOrder;
    String invoiceNumber;

    @Then("{string} tab should display")
    public void tabShouldDisplay(String tabName) {
        basePage.checkTabDisplay(tabName);
    }

    @When("User Validate retailer adding functionality")
    public void User_Validate_retailer_adding_functionality() {
        retailersPage.createRetailer();
    }

    @When("User click on hamburger goes to {string} in retailers and inventory")
    public void userClickOnHamburgerGoesToInRetailersAndInventory(String inventoryPages) {
        dashBoardPage.navToInventoryPages(inventoryPages);
    }

    @When("User Validate Inbound Type will only be RMA")
    public void User_Validate_Inbound_Type_will_only_be_RMA() {
        shipmentPage.validateInboundOnlyOnRMA();
    }

    @When("User create purchase order with location Warehouse")
    public void userCreatePurchaseOrderWithLocationWarehouse() {
        transponderInventoryPage.createTransponderInventoryPurchaseOrder();
    }

    @Then("User inspect the columns of new transponder inventory purchase order data are displaying")
    public void userInspectTheColumnsOfNewTransponderInventoryPurchaseOrderDataAreDisplaying() {
        transponderInventoryPage.validatePurchaseOrderDataDisplays();
    }

    @When("User create retailer purchase order")
    public void userCreateRetailerPurchaseOrder(Map<String, String> transponderDetails) {
        retailersPage.createRetailerPurchaseOrder(transponderDetails);
    }

    @Then("Success message should display for retailer adding")
    public void successMessageShouldDisplayForRetailerAdding() {
        retailersPage.validateSuccessMessageForRetailerAdding();
    }

    @And("user select purchase order to review for the scenario {string}")
    public void userSelectPurchaseOrderToReviewForTheScenario(String scenarioName) {
        retailersPage.reviewPurchaseOrder(scenarioName);
    }

    @When("User choose Edit in Action of Retailer {string}")
    public void userChooseEditInActionOfRetailer(String retailerName) {
        retailer = retailerName;
        retailersPage.chooseEditInActionOfRetailer(retailerName);
    }

    @Then("{string} window should display")
    public void windowShouldDisplay(String windowName) {
        basePage.checkWindowDisplay(windowName);
    }

    @When("User select History tab")
    public void userSelectHistoryTab() {
        retailersPage.clickOnHistory();
    }

    @Then("Order History list view should display")
    public void orderHistoryListViewShouldDisplay() {
        retailersPage.validateOrderHistoryListView(retailer);
    }

    @When("User goes to search tab and search for transponder with customer retained status from dropdown filter")
    public void userGoesToSearchTabAndSearchForTransponderWithCustomerRetainedStatusFromDropdownFilter() {
        transponderInventoryPage.searchForTransponderWithCustomerRetainedStatusFromDropdownFilter();
    }

    @Then("Search results display transponders with the status customer retained")
    public void searchResultsDisplayTranspondersWithTheStatusCustomerRetained() {
        transponderInventoryPage.SearchResultsDisplayTranspondersWithTheStatusCustomerRetained();
    }

    @When("User goes to search tab and search for business with flex transponder from dropdown filter")
    public void userGoesToSearchTabAndSearchForBusinessWithFlexTransponderFromDropdownFilter() {
        transponderInventoryPage.searchForBusinessWithFlexTransponderFromDropDownFilter();
    }

    @Then("Search results display transponders model flex")
    public void searchResultsDisplayTranspondersModelFlex() {
        transponderInventoryPage.SearchResultsDisplayTranspondersModelFlex();
    }

    @When("User save quick search and select refine search")
    public void userSaveQuickSearchAndSelectRefineSearch() {
        transponderInventoryPage.saveQuickSearchAndSelectRefineSearch();
    }

    @Then("Search screen displays with the new record quick search")
    public void searchScreenDisplaysWithTheNewRecordQuickSearch() {
        transponderInventoryPage.searchScreenDisplaysWithTheNewRecordQuickSearch();
    }

    @When("User deletes the new record quick search")
    public void userDeletesTheNewRecordQuickSearch() {
        transponderInventoryPage.deleteTheNewRecordQuickSearch();
    }

    @Then("New record should not be displayed in quick search list")
    public void newRecordShouldNotBeDisplayedInQuickSearchList() {
        transponderInventoryPage.newRecordShouldNotBeDisplayedInQuickSearchList();
    }

    @When("User click edit from action drop down next to purchase order number")
    public void userClickEditFromActionDropDownNextToPurchaseOrderNumber() {
        transponderInventoryPage.clickEditFromActionDropDownNextToPurchaseOrderNumber();
    }

    @When("User update the location to {string} and click save")
    public void userUpdateTheLocationToAndClickSave(String transponderLocation) {
        transponderInventoryPage.updateTransponderLocationAndClickSave(transponderLocation);
    }

    @Then("Success message should display and location updated to {string}")
    public void successMessageShouldDisplayAndLocationUpdatedTo(String transponderLocation) {
        transponderInventoryPage.successMessageShouldDisplayAndLocationUpdatedTo(transponderLocation);
    }

    @When("User click on {string}")
    public void userClickOn(String buttonName) {
        basePage.clickElement(buttonName);
    }

    @When("User enter Retailer Location Details and click Save button")
    public void userEnterRetailerLocationDetailsAndClickSaveButton() {
        retailerLocation = retailersPage.enterRetailerLocationDetailsAndSave();
    }

    @Then("{string} toast message should display")
    public void toastMessageShouldDisplay(String toastMessage) {
        basePage.validateToastMessage(toastMessage);
    }

    @And("Retailer Locations list should be updated")
    public void retailerLocationsListShouldBeUpdated() {
        retailersPage.validateUpdatedRetailerLocationList(retailerLocation);
    }

    @When("User select {string} tab")
    public void userSelectTab(String tabName) {
        basePage.clickLink(tabName);
    }

    @When("User filters status by initializing and choose assign transponder from action dropdown")
    public void userFiltersStatusByInitializingAndChooseAssignTransponderFromActionDropdown() {
        transponderInventoryPage.filtersStatusByInitializingAndChooseAssignTransponderFromActionDropdown();
    }

    @When("User choose {string} from employee name dropdown and {string} from location dropdown and click Save button")
    public void userChooseFromEmployeeNameDropdownAndFromLocationDropdownAndClickSaveButton(String employeeName, String transponderLocation) {
        transponderInventoryPage.userChooseEmployeeAndLocationFromDropDowns(employeeName, transponderLocation);
    }

    @And("Agent {string} and location {string} are updated in the list for that transponder")
    public void agentAndLocationAreUpdatedInTheListForThatTransponder(String employeeName, String locationName) {
        transponderInventoryPage.locationAndAgentAreUpdatedInTheListForThatTransponder(employeeName, locationName);
    }

    @When("User select transponder number from the listview")
    public void userSelectTransponderNumberFromTheListview() {
        transponderInventoryPage.selectTransponderNumberFromTheListview();
    }

    @And("User review information in the summary tab")
    public void userReviewInformationInTheSummaryTab() {
        transponderInventoryPage.reviewInformationInTheSummaryTab();
    }

    @When("User select {string} from window tab")
    public void userSelectFromWindowTab(String tabName) {
        basePage.clickElement(tabName);
    }

    @And("User review information in the history tab and close window")
    public void userReviewInformationInTheHistoryTabAndCloseWindow() {
        transponderInventoryPage.reviewInformationInTheHistoryTabAndCloseWindow();
    }

    @When("User select {string} from the top of the screen")
    public void userSelectFromTheTopOfTheScreen(String advanceSearch) {
        basePage.clickElement(advanceSearch);
    }

    @Then("Advanced search options are displayed")
    public void advancedSearchOptionsAreDisplayed() {
        dashBoardPage.advancedSearchOptionsAreDisplayed();
    }

    @When("User enter {string} {string} in the input field and click {string}")
    public void userEnterInTheInputFieldAndClick(String inputField, String inputValue, String buttonName) {
        dashBoardPage.advanceSearchByTransponderNumber(inputField, inputValue, buttonName);
    }

    @Then("Account associated with the transponder is displayed with account number {string}")
    public void accountAssociatedWithTheTransponderIsDisplayedWithAccountNumber(String accountNumber) {
        accountPage.transpondersAccountIsDisplayed(accountNumber);
    }

    @When("User select {string} tab for the account")
    public void userSelectTabForTheAccount(String accountTabName) {
        basePage.clickElement(accountTabName);
    }

    @Then("{string} tab for the account display")
    public void tabForTheAccountDisplay(String accountTabName) {
        basePage.checkSpanDisplay(accountTabName);
    }

    @And("Transponder number {string} is shown in listview and Account history as {string}")
    public void transponderNumberIsShownInListviewAndAccountHistoryAs(String transponderNumber, String historyTabNote) {
        accountPage.transponderExistInTransponderTab(transponderNumber);
        basePage.clickElement("Account History");
        accountPage.transponderExistInHistoryTabWithNote(transponderNumber, historyTabNote);
    }

    @When("User select the action dropdown next to a transponder number {string} and choose {string}")
    public void userSelectTheActionDropdownNextToATransponderNumberAndChoose(String transponderNumber, String optionsFromActionDropDown) {
        accountPage.chooseFromActionDropDown(transponderNumber, optionsFromActionDropDown);
    }

    @And("Transponder current status {string}")
    public void transponderCurrentStatus(String transponderCurrentStatus) {
        accountPage.checkTransponderStatusOnChangeStatusWindow(transponderCurrentStatus);
    }

    @When("User Select New Status dropdown choose {string} and select Save button")
    public void userSelectNewStatusDropdownChooseAndSelectSaveButton(String desireTransponderStatus) {
        accountPage.updateTransponderStatus(desireTransponderStatus);
    }

    @Then("Popup display {string}")
    public void popupDisplay(String verifyTransponderChanges) {
        accountPage.verifyWindowDisplayAndClickOk(verifyTransponderChanges);
    }

    @And("Transponder number {string} status updated to {string}")
    public void transponderNumberStatusUpdatedTo(String transponderNumber, String transponderNewStatus) {
        accountPage.checkTransponderStatusOnListView(transponderNumber, transponderNewStatus);
    }

    @When("User enter New Retailer User Account Details and click Save button")
    public void userEnterNewRetailerUserAccountDetailsAndClickSaveButton() {
        retailer = retailersPage.createNewRetailerUserDetails();
    }

    @When("User select {string} in Retailers list")
    public void userSelectInRetailersList(String retailerName) {
        retailersPage.clickOnRetailer(retailerName);
    }

    @Then("Retailer Users list should be updated")
    public void retailerUsersListShouldBeUpdated() {
        retailersPage.validateUpdatedRetailerUsersList(retailer);
    }

    @When("Select Orders with the Fulfillment status of {string}")
    public void userSelectOrdersWithActiveRequest(String status) {
        retailersPage.selectOrdersWithActiveRequest(status);
    }

    @Then("{string} tab Title should display")
    public void checkPurchaseOrderDETAILS(String menuTitle) {
        retailersPage.checkOrderDetailsDisplay(menuTitle);
    }

    @When("User update the Transponder Quantity as {string} and select Save")
    public void updateAndSaveTransponderQuantity(String quantity) {
        retailersPage.UpdateTransponderQuantity(quantity);
    }

    @Then("Transponder quantity should be updated as {string}")
    public void verifyTransponderQuantity(String quantity) {
        retailersPage.checkOrderDetailsUpdated(quantity);
    }

    @Then("{string} page is the default")
    public void verifyDefaultPage(String pageName) {
        retailersPage.checkTabDisplay(pageName);
    }

    @When("Locate an order with {string} status and select the action list drop down")
    public void userSelectActionDropdownWithStatus(String status) {
        retailersPage.selectActionDropdownWithStatus(status);
    }

    @Then("verify {string} and {string} are options displayed")
    public void verifyOptionsOfActionDropdown(String options1, String options2) {
        retailersPage.verifyOptionsOfActionDropdown(options1, options2);
    }

    @Then("User Select Actions Dropdown as {string}")
    public void selectActionsDropdown(String option) {
        retailersPage.selectActionDropdown(option);
    }

    @When("Enter the reason as {string} and select save")
    public void userEnterReasonAndSelect(String reason) {
        retailersPage.enterReasonAndSave(reason);
    }

    @Then("verify order is removed from the Retailer orders list")
    public void verifyOrderRemoved() {
        retailersPage.verifyOrderRemoved();
    }

    @When("User select {string}")
    public void userSelectNewJournalEntry(String text) {
        shipmentPage.clickNewJournalEntry(text);
    }

    @Then("User set Category as {string} in row {string}")
    public void selectCategoryDropdown(String option, String rowNum) {
        shipmentPage.selectCategory(rowNum, option);
    }

    @Then("User set GL Code as {string} in row {string}")
    public void selectGLCodeDropdown(String option, String rowNum) {
        shipmentPage.selectGLCode(rowNum, option);
    }

    @Then("User set Debit as {string} in row {string}")
    public void userSetDebit(String debit, String rowNum) {
        shipmentPage.enterDebit(rowNum, debit);
    }

    @Then("User set Credit as {string} in row {string}")
    public void userSetCredit(String credit, String rowNum) {
        shipmentPage.enterCredit(rowNum, credit);
    }

    @Then("User Enter comment in Memo section as {string}")
    public void userEnterMemo(String memo) {
        shipmentPage.enterMemo(memo);
    }

    @Then("User click {string}")
    public void userClickSaveOrCancle(String saveOrCancle) {
        shipmentPage.clickSaveOrCancle(saveOrCancle);
    }

    @Then("Verify The new journal entry created and it is {string} Status")
    public void verifyJournalEntryStatus(String status) {
        shipmentPage.checkNewEntryStatus(status);
    }

    @Then("User select the entry actions list and select {string}")
    public void userSelectActionsListWithEditOrReview(String options) {
        shipmentPage.selectNewEntryDropDownOption(options);
    }

    @When("User select the {string} radio button")
    public void userSelectJournalEntryReviewStatus(String editOrReview) {
        shipmentPage.selectJournalEntryReviewStatus(editOrReview);
    }

    @Then("Verify Intentional Pause to verify Journal Entry next day")
    public void verifyJournalEntryNextDay() {
        shipmentPage.checkJournalEntryRemoved();
    }

    @When("User filters by purchase order created in scenario {string}")
    public void userFiltersByPurchaseOrderCreatedInScenario(String scenarioName) {
        purchaseOrder = fulfillmentPage.filterPurchaseOrder(scenarioName);
    }

    @Then("purchase order number should display")
    public void purchaseOrderNumberShouldDisplay() {
        basePage.checkLinkDisplay(purchaseOrder);
    }

    @When("User choose Process Order in Action of selected Purchase Order")
    public void userChooseProcessOrderInActionOfSelectedPurchaseOrder() {
        fulfillmentPage.chooseProcessOrderInAction();
    }

    @When("User select Multiple transponders and click Next")
    public void userSelectMultipleTranspondersAndClickNext() {
        fulfillmentPage.selectMultipleTranspondersAndClickNext();
    }

    @When("User enter transponder details and click next")
    public void userEnterTransponderDetailsAndClickNext() {
        fulfillmentPage.enterTransponderDetailsAndClickNext();
    }

    @When("User select all transponders and click ship later")
    public void userSelectAllTranspondersAndClickShipLater() {
        fulfillmentPage.selectAllTranspondersAndClickShipLater();
    }

    @And("{string} link should display")
    public void linkShouldDisplay(String screenLink) {
        basePage.checkLinkDisplay(screenLink);
    }

    @When("User filters by number created in scenario {string}")
    public void userFiltersByNumberCreatedInScenario(String scenarioName) {
        purchaseOrder = shipmentPage.filterByNumber(scenarioName);
    }

    @When("User update Retailer Details")
    public void userUpdateRetailerDetails() {
        retailersPage.updateRetailersDetails();
    }

    @And("revert the Retailer Details back")
    public void revertTheRetailerDetailsBack() {
        retailersPage.revertRetailersDetails("GIANT");
    }

    @When("User select the shipment queue actions list and select {string}")
    public void userSelectShipmentQueueActionsListWith(String options) {
        shipmentPage.selectActionDropdown(options);
    }

    @When("User select shipmentDate as today's date")
    public void userSelecShipmentDateAsToday() {
        shipmentPage.selectShipmentDate();
    }

    @Then("Verify the current date is displayed")
    public void verifyShipmentDateDisplayed() {
        shipmentPage.checkShipmentDateDisplayed();
    }

    @Then("User select shipper type as {string}")
    public void userSelectShipperType(String type) {
        shipmentPage.selectShipperType(type);
    }

    @Then("User select service Level as {string}")
    public void userSelecServiceLevel(String level) {
        shipmentPage.selectServiceLevel(level);
    }

    @Then("User type the tracking number as {string}")
    public void UserEnterTrackingNumber(String number) {
        shipmentPage.enterTrackingNumber(number);
    }

    @When("User select expected delivery Date at {string} days from today")
    public void userSelectExpectedDeliveryDate(String days) {
        shipmentPage.selectExpectedDeliveryDate(days);
    }

    @Then("Verify the expected delivery date is displayed")
    public void verifyExpectedDeliveryDateDisplayed() {
        shipmentPage.checkExpectedDeliveryDate();
    }

    @Then("User click on complete shipment button at ship order window")
    public void clickCompleteShipmentButton() {
        invoiceNumber = shipmentPage.getinvoiceNumberInputField();
        purchaseOrder = shipmentPage.getPurchOrderNumberFromInputFiled();
        shipmentPage.clickCompleteShipment();
    }

    @Then("verify {string} message displayed")
    public void verifySuccessMessageDisplayed(String msg) {
        shipmentPage.checkRetailerProcessOrderSuccessMessgaeDisplayed(msg);
    }

    @Then("Verify shipper type is selected as {string}")
    public void verifyShipperTypeDisplayed(String type) {
        shipmentPage.verifyGenericShopOrderOption(type);
    }

    @Then("Verify service Level is selected as {string}")
    public void verifyServiceLevelDisplayed(String level) {
        shipmentPage.verifyGenericShopOrderOption(level);
    }

    @Then("Verify tracking number is entered as {string}")
    public void verifyTrackingNumberDisplayed(String tNumber) {
        shipmentPage.verifyTrackingNumber(tNumber);
    }

    @Then("User enter transponder quantity as {string}")
    public void userEnterTransponderQuantity(String quantity){
        retailersPage.enterTransponderQuantity(quantity);
    }
}