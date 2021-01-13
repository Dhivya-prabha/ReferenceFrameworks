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
public class RetailerDriveezmdPaymentPage extends BasePage {

    By sideNavSlideout = By.xpath("//mat-icon[text()='menu']");
    By sideNavSlideIn = By.xpath("//mat-icon[text()='arrow_back']");
    By postDateColumn = By.xpath("//button[contains(text(),'Post Date')]");
    By genericFirstColumnData = By.xpath("//td[contains(@class,'XXX')]");

    public void clickHamburgerMenu(){
        clickElement(sideNavSlideout);
    }

    public void clickArrowback(){
        clickElement(sideNavSlideIn);
    }

    public void verifyPaymentsPageDisplayed(){
        checkElementPresence(getLocator(genericDiv,"Payments"));
    }

    public void sortDateColumn() {
        clickElement(postDateColumn);
        waitSeconds(4);
        clickElement(postDateColumn);
        waitSeconds(4);
    }

    public  void checkInvoiceNumber(String invoiceNumber){
        Assert.assertEquals("Invoice Number not found",getElement(getLocator(genericFirstColumnData, "invoice")).getText(), invoiceNumber);
    }

    public  void checkPaymentDate(String paymentDate){
        Assert.assertEquals("Payment Date Details not found",getElement(getLocator(genericFirstColumnData, "updated")).getText(), paymentDate);
    }
}