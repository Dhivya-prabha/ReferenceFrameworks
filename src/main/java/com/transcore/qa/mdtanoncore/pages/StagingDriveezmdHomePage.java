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
public class StagingDriveezmdHomePage extends BasePage {

    By siteName = By.xpath("//a[@class='brand' and contains(@href,'staging.driveezmd.com')]");

    public void navigateMenuItem(String menuItem) {
        clickElement(getLocator(genericAnchor, menuItem));
    }

    public void checkHomeScreenDisplay() {
        checkElementPresence(siteName);
        clickElement(getLocator(genericAnchor, "No Thanks"));
    }
}
