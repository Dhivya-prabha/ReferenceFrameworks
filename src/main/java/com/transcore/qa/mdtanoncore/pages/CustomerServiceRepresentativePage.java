package com.transcore.qa.mdtanoncore.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CustomerServiceRepresentativePage extends BasePage{

    public By sideNavSlideout = By.xpath("//i[@class='navToggle sideNavSlideout']");
    By imageCertificationTab = By.xpath("//a[contains(text(),'Image Re-review')]");

    public void clickOnHamburger() {
        clickElement(sideNavSlideout);
    }

    public void ClickOnUnpaid(String clickUnpaid) {
        clickElement(getLocator(genericPage, clickUnpaid));
    }

    public void imageReview() {
        Assert.assertTrue("Image Certification tab displayed in the screen",
                getElements(imageCertificationTab).isEmpty());
    }

    public void checkAccountTypeElementNotDisplay() {
        checkElementNotPresent(getLocator(genericDropdownOption, "Non-revenue"));
    }
}