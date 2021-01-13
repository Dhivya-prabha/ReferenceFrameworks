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
public class ReportsPage extends BasePage {

    By last7Days = By.xpath("//md-radio-button[@aria-label='Last 7 days']");
    By calendarIcon = By.xpath("//span[@class='k-icon k-i-calendar']");
    By currentDate = By.xpath("//td[contains(@aria-label,'Current focused date')]/a");

    public void selectLast7Days(){
        clickElement(last7Days);
    }

    public void checkReportDetails(String reportText){
        switchToFrame(0);
        checkTextDisplay(reportText);
        switchToDefaultContent();
    }

    public void selectTodayDate(){
        clickElement(calendarIcon);
        clickElement(currentDate);
    }

}
