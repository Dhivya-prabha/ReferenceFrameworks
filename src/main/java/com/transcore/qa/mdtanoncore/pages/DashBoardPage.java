package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class DashBoardPage extends BasePage {

    String accountNumberOnAccountSummaryPage = "//h4[contains(text(),'XXX')]";

    public By sideNavSlideout = By.xpath("//i[@class='navToggle sideNavSlideout']");
    By sideNavSlideIn = By.xpath("//i[@class='navToggle sideNavSlideIn']");
    By retailersAndInventory = By.xpath("//p[contains(text(),'Retail & Inventory')]");
    By shipments = By.xpath("//p[contains(text(),'Shipments')]");
    By agencyLocationVerify = By.xpath("//a[contains(text(),'Agency Locations')]");
    By tabSelection = By.xpath("//div/nav");
    By mainMenu = By.xpath("//*[@id='home-page-div']/tc-main-navigation-menu/div/ul/li/a/p");
    By configSubMenu = By.xpath("//*[@id='home-page-div']/tc-main-navigation-menu/div/ul/li/ul[@aria-labelledby='dropdownMenu3']/li/a/p");
    By systemDownArrowSubMenu = By.xpath("//*[@class='nav nav-pills username-container pull-right']/li[last()]/ul/li/a");
    By advanceSearchOptions = By.id("divAdvancedSearch");
    By transponderNumberInput = By.xpath("//input[@ng-model='$ctrl.search.txtTagNo']");
    By searchInput = By.id("searchInput");
    By searchIcon = By.id("searchInputImg");
    By navbar = By.className("flyout-navbar");
    By genericInputNumber = By.xpath("//label[contains(text(),'XXX')]/following-sibling::input");
    By genericViewPage = By.xpath("//div[@ui-view='XXX']");
    By userIcon = By.xpath("//span[@class='user-icon']");
    By endShift = By.xpath("//i[@class='icon icon-endshift']");

    public void navToInventoryPages(String inventoryPages) {
        clickElement(sideNavSlideout);
        clickElement(retailersAndInventory);
        clickElement(getLocator(genericPage, inventoryPages));
    }

    public void clickHamburgerMenu(){
        clickElement(sideNavSlideout);
    }

    public void advancedSearchOptionsAreDisplayed() {
        checkElementPresence(advanceSearchOptions);
    }

    public void advanceSearchByTransponderNumber(String inputField, String inputValue, String buttonName) {
        enterText(getLocator(genericInputNumber,inputField),inputValue);
        clickElement(getLocator(genericButton,buttonName));
    }

    public void searchAccount(String details) {enterText(searchInput,details);clickElement(searchIcon);}

    public void checkHamburgerMenuDisplay(){ checkElementPresence(navbar); }

    public void dasboardTabVisibility() {
        List<String> tabSelectionmatch = Arrays.asList("IMAGE REVIEW", "CALL CENTER", "FINANCIAL", "ACCOUNT", "INVENTORY", "CASE MANAGEMENT", "DOCUMENT MANAGEMENT");
        List<WebElement> tabSelectionList = getElements(tabSelection);
        List<String> tabsFromUI = new ArrayList<String>();
        tabsFromUI = Arrays.asList(tabSelectionList.get(0).getText().split("\n"));
        Serenity.takeScreenshot();
        Assert.assertArrayEquals("Home tab displays", tabSelectionmatch.toArray(), tabsFromUI.toArray());
    }

    public void mainMenuVisibility() {
        List<String> menuSelectionmatch = Arrays.asList("CREATE ACCOUNT", "REGISTER ON THE GO", "SALE ON THE GO", "CONFIGURATION", "CASE MANAGEMENT", "DOCUMENT MANAGEMENT", "FINANCE", "IMAGE REVIEW", "OPS MONITOR", "REPORTS", "RETAIL & INVENTORY", "SHIFT MANAGEMENT", "UNPAID", "INTEROPERABILITY");
        List<String> menuFromUI = new ArrayList<String>();
        getElements(mainMenu).forEach(element -> menuFromUI.add(element.getText()));
        Serenity.takeScreenshot();
        Assert.assertArrayEquals("Main main not dispalyed based on user role", menuSelectionmatch.toArray(), menuFromUI.toArray());
    }

    public void configurationSubMenuVisibility() {
        List<String> configurationSubMenu = Arrays.asList("Account Types", "Account Fees", "Agency Locations", "Image Processing", "Global Settings", "Users and Roles", "Case Management", "Customer Communication", "Self Service", "Holidays");
        List<String> menuFromUI = new ArrayList<String>();
        getElements(configSubMenu).forEach(element -> menuFromUI.add(element.getText()));
        Serenity.takeScreenshot();
        Assert.assertArrayEquals("Main main not dispalyed based on user role", configurationSubMenu.toArray(), menuFromUI.toArray());
    }

    public void systemDownArrowSubMenu() {
        List<String> systemDownArrowSubMenuItem = Arrays.asList("End Shift", "Change Password", "My Preferences", "Logout");
        List<String> menuFromUI = new ArrayList<String>();
        getElements(systemDownArrowSubMenu).forEach(element -> menuFromUI.add(element.getText()));
        Serenity.takeScreenshot();
        Assert.assertArrayEquals("Main main not dispalyed based on user role", systemDownArrowSubMenuItem.toArray(), menuFromUI.toArray());
    }

    public void hamburgerClick() {
        clickElement(sideNavSlideout);
    }

    public void hamburgerClickSlidein() {
        clickElement(sideNavSlideIn);
    }

    public void verfiyMenuHidden() {
        checkElementPresence(sideNavSlideout);
    }

    public void verifyAgencyLoc() {
        checkElementPresence(agencyLocationVerify);
    }

    public void clickElementWithPtag(String linkName) {
        clickElement(getLocator(genericPage, linkName));
    }

    public void navToViewPage(String viewPage) {
        checkElementPresence(getLocator(genericViewPage,viewPage));
    }

    public void clickUserIcon() { clickElement(userIcon);}

    public void verifyEndShift() {checkElementNotPresent(endShift);}
}