package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class SystemPage extends BasePage {
    public static By myPrefencelang = By.xpath("//*[@class='md-text ng-binding' and text()='English']");
    public static By theme = By.xpath("//*[@class='md-primary md-checked' and @aria-label='Integrity Blue']");

    By systemDownArrow = By.xpath("//*[@class='username-txt hidden-xs ng-binding']");
    By endShiftLink = By.xpath("//i[@class='icon icon-endshift']");
    By closeEndShift = By.xpath("//*[@class='ng-scope' and @aria-label='Close dialog']");
    By changePasswordLink = By.xpath(" //*[@ng-click='$ctrl.changePassword()']");
    By myPreferenceLink = By.xpath("//*[@ng-click='$ctrl.updateMyPreference()']");
    By loginScreen = By.xpath("//*[@class='login layout-wrap layout-row']");
    By logoutPopup = By.xpath("//*[@class='ng-binding' and text()='Do you want to end the shift before log out?']");

    public void systemDownArrow() {
        waitForElement(10, systemDownArrow);
        clickElement(systemDownArrow);
    }

    public void endShift() {
        clickElement(endShiftLink);
    }

    public void endShiftClose() {
        clickElement(closeEndShift);
    }

    public void enterPassword(String password) {
        enterText(getLocator(genericText, "returnFromPsw"), password);
    }

    public void endShiftAmount(String amount) {
        enterText(getLocator(genericText, "txtCheckAmt"), amount);
    }

    public void changePassword() {
        clickElement(changePasswordLink);
    }

    public void myPreference() {
        clickElement(myPreferenceLink);
    }

    public void tabNameDisplays(String tabName) {
        checkElementPresence(getLocator(genericSpan, tabName));
    }

    public void logoutPopup() {
        checkElementPresence(logoutPopup);
    }

    public void returnToLogin() {
        checkElementPresence(loginScreen);
    }

}
