package com.transcore.qa.mdtanoncore.pages;

import io.cucumber.datatable.DataTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Data
@EqualsAndHashCode(callSuper=false)
@Slf4j
public class AccountPage extends BasePage {

    By genericTransponderNumber = By.xpath("//td/a[contains(text(),'XXX')]");
    By genericHistoryNoteWithTransponderNumber = By.xpath("//td/a[contains(text(),'XXX')]/parent::td/following-sibling::td[2]/span");
    By genericTransponderNumberActionDropDown = By.xpath("//tr//a[contains(text(),'XXX')]/parent::td/preceding-sibling::td[2]//md-select");
    By transponderStatusChangeStatusWindow = By.id("txtCurrentStatus");
    By tagFilter = By.xpath("//th[@data-field='vehicleTagNumber']//span");
    By searchInput = By.id("txtFilter_vehicleTagNumber");
    By filterButton = By.id("btnsub_vehicleTagNumber");
    By transponderStatusDropdown = By.id("ddlTagStatus");
    By genericTransponderNumberStatus = By.xpath("//td/a[contains(text(),'XXX')]/parent::td/following-sibling::td[4]");
    By setAsDeceased = By.id("btnCertificateFileUpload");
    By fileUploadButton = By.xpath("//span[contains(text(),'Drop files here to upload')]/a[text()='Browse']");
    By accountTypePage = By.xpath("//div[@ui-view='AccountType']");
    By accountType = By.id("ddlAccountType");
    By accountTypeOptions = By.xpath("//md-option[@ng-value='accountType.accountTypeID']");
    By bankruptcy = By.id("btnBankruptcy");

    By genericTransponderActionsDropdown = By.xpath("(//span[contains(text(),'XXX')]/../preceding-sibling::td//span[text()='Actions'])[1]");
    By genericTransponderDisplayedDropdownOption = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[text()='XXX']");

    public void chooseFromActionDropDown(String transponderNumber, String optionsFromActionDropDown) {
        clickElement(tagFilter);
        getElement(searchInput).clear();
        enterText(searchInput,transponderNumber);
        clickElement(filterButton);
        clickElement(getLocator(genericTransponderNumberActionDropDown, transponderNumber));
        clickElement(getLocator(genericDiv,optionsFromActionDropDown));
    }

    public void transpondersAccountIsDisplayed(String accountNumber) {
        checkElementPresence(getLocator(genericH4,accountNumber));
    }

    public void transponderExistInTransponderTab(String transponderNumber) {
        checkElementPresence(getLocator(genericTransponderNumber,transponderNumber));
    }

    public void transponderExistInHistoryTabWithNote(String transponderNumber, String historyTabNote) {
        Assert.assertEquals("Transponder "+transponderNumber+" not exists", historyTabNote, getElement(getLocator(genericHistoryNoteWithTransponderNumber,transponderNumber)).getText());
    }

    public void checkAccountNumberDisplay(String accountNO){
        checkElementPresence(getLocator(genericH4,accountNO));
    }

    public void clickAccountActions() { clickElement(getLocator(genericSpan,"Account Actions")); }

    public void clickSetAsDeceased() {
        clickAccountActions();
        clickElement(setAsDeceased);
    }

    public void checkUploadDeathCertificateWindowDisplay(String msg) {
        checkElementPresence(getLocator(genericH2,msg));
        checkElementPresence(fileUploadButton);
    }

    public void checkCreateAccountPageDisplay() {
        checkElementPresence(accountTypePage);
    }

    public void clickAccountType() {
        clickElement(accountType);
    }

    public void verifyAccountTypeOptions(DataTable data) {
        pollForElement(5, accountTypeOptions);
        Set<String> setOfOptions = new HashSet<String>();
        for (WebElement eachOptions : getElements(accountTypeOptions)) {
            setOfOptions.add(eachOptions.getText().trim());
        }
        for (String eachValue : data.asList()) {
            Assert.assertTrue(setOfOptions.contains(eachValue));
        }
    }

    public void checkTransponderStatusOnChangeStatusWindow(String transponderCurrentStatus) {
        String transponderStatus=getElement(transponderStatusChangeStatusWindow).getAttribute("value");
        Assert.assertEquals("Transponder status not as expected",transponderCurrentStatus,transponderStatus);
    }

    public void updateTransponderStatus(String desireTransponderStatus) {
        clickElement(transponderStatusChangeStatusWindow);
        enterText(transponderStatusDropdown,desireTransponderStatus);
        clickElement(getLocator(genericSpan,"SAVE"));
    }

    public void verifyWindowDisplayAndClickOk(String verifyTransponderChanges) {
        checkElementPresence(getLocator(genericDiv,verifyTransponderChanges));
    }

    public void checkTransponderStatusOnListView(String transponderNumber, String transponderNewStatus) {
        Assert.assertEquals("Transponder "+transponderNumber+" status not as expected", transponderNewStatus,
                getElement(getLocator(genericTransponderNumberStatus,transponderNumber)).getText());
    }

    public void clickAndNavigateToAccountTab(String tabName){
        clickElement(getLocator(genericSpan,tabName));
    }

    public void clickTransponderActionsDropDown(String columnValue){
        clickElement(getLocator(genericTransponderActionsDropdown,columnValue));
    }

    public void verifyTransponderActionsDropDownWithOption(String option) {
        checkElementPresence(getLocator(genericTransponderDisplayedDropdownOption,option));
    }

    public void checkBankruptcy() {checkElementNotEnabled(bankruptcy);}
}