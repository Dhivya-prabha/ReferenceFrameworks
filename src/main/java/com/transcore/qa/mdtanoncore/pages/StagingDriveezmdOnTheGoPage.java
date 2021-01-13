package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class StagingDriveezmdOnTheGoPage extends BasePage {

    public void clickOnLink(String text) {
        clickElement(getLocator(genericAnchor, text));
    }
}
