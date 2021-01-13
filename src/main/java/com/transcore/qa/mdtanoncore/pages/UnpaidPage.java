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
public class UnpaidPage extends BasePage {

    By image = By.xpath("//img[contains(@src,'data:image')]");
    By courtHearing = By.xpath("//a[@ui-sref='Unpaid.CourtScheduler']");
    By accept = By.id("btnAccept");
    By reject = By.id("btnReject");
    By loader = By.xpath("(//div[@class='loader'])[2]");
    By loaderHide = By.xpath("//div[@class='loader ng-hide']");
    By unpaidPage = By.xpath("//div[@ui-view='Unpaid']");

    public void navToUnpaidPage() {
        checkElementPresence(unpaidPage);
    }

    public void clickImageCertification() {
        waitForElement(loader);
        pollForElement(50, loaderHide);
        pollForElement(10, getLocator(genericAnchor,"Image Certification"));
        clickElement(getLocator(genericAnchor,"Image Certification"));
    }

    public void checkAcceptAndRejectDisplay() {
        checkElementPresence(image);
        checkElementPresence(accept);
        checkElementPresence(reject);
    }

    public void checkCourtHearingNotDisplay() { checkElementNotPresent(courtHearing); }
}