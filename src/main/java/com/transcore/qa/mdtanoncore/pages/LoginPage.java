package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class LoginPage extends BasePage {

    By userNameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.id("btnSubmit");

    public void loginUser(String integrityUsername, String integrityPassword) {
        waitForElement(60, userNameInput);
        enterText(userNameInput,integrityUsername);
        enterText(passwordInput,integrityPassword);
        clickElement(submitButton);
    }
}
