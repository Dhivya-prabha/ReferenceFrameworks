package com.transcore.qa.mdtanoncore.pages;

import io.cucumber.java.en.Then;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class RetailerDriveezmdLoginPage extends BasePage {

    By userNameInput = By.xpath("//label[text()='Username']/preceding::input[1]");
    By passwordInput = By.xpath("//label[text()='Password']/preceding::input[1]");
    By signIn = By.xpath("//span[contains(text(),'Sign In')]/parent::button[not(@disabled='true')]");
    By captcha = By.id("recaptcha-anchor");
    By screenName = By.xpath("//mat-card-title[text()='Retailer Login']");

    public void loginUser(String integrityUsername, String integrityPassword) {
        waitForElement(20, userNameInput);
        enterText(userNameInput,integrityUsername);
        enterText(passwordInput,integrityPassword);
        switchToFrame(0);
        clickElement(captcha);
        switchToDefaultContent();
        waitSeconds(80);
        clickElement(signIn);
    }

    public void checkRetailerLoginScreenDisplayed() {
        checkElementPresence(screenName);
    }
}
