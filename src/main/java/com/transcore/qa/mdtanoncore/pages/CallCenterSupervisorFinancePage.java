package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j

public class CallCenterSupervisorFinancePage extends BasePage {

    By verifyFinanceTab = By.xpath("//*[@class='ng-scope ng-binding' and text()='Finance']");

    public void checkElementPresence() {
        Assert.assertTrue("Finance menu displayed in the screen",
                getElements(verifyFinanceTab).isEmpty());
    }
}