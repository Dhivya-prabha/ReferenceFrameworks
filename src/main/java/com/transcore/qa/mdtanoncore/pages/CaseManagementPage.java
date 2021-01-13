package com.transcore.qa.mdtanoncore.pages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper=false)
@Slf4j
public class CaseManagementPage extends BasePage {

    public void setCaseManagement() {
        Assert.assertTrue("configuration displayed in the screen",
                getElements(getLocator(genericPara,"CONFIGURATION")).isEmpty());
    }
}