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
public class RetailerDriveezmdDashBoardPage extends BasePage {

    By sideNavSlideout = By.xpath("//mat-icon[text()='menu']");
    By sideNavSlideIn = By.xpath("//mat-icon[text()='arrow_back']");
    By orderNumber = By.xpath("//td[contains(@class,'order-number')]");

    public void clickHamburgerMenu(){
        clickElement(sideNavSlideout);
    }

    public void clickArrowback(){
        clickElement(sideNavSlideIn);
    }

    public void navToRetailerPages(String pageName) {
        clickElement(sideNavSlideout);
        clickElement(getLocator(genericDiv,pageName));
    }
}