package com.transcore.qa.mdtanoncore.pages;


import com.transcore.qa.mdtanoncore.transferobjects.TestContextTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class FulfillmentPage extends BasePage {

    public String filterPurchaseOrder(String scenarioName) {
        String purchaseOrder = testContextTO.getScenarioPOMap().get(scenarioName);
        clickElement(getLocator(poFilterLink,"PO Number"));
        enterText(poNumberInput,purchaseOrder);
        clickElement(filterButton);
        return purchaseOrder;
    }

    public void chooseProcessOrderInAction() {
        clickElement(getLocator(genericSpan,"Action"));
        clickElement(getLocator(actionOptions, "Process Order"));
    }

    public void selectMultipleTranspondersAndClickNext() {
        clickElement(getLocator(genericSpan,"Multiple transponders"));
        clickElement(getLocator(genericSpan, "Next"));
    }

    public void enterTransponderDetailsAndClickNext() {
        Map<String, String> testDataMap = fileUtil.readMapFromFile(filePath);
        String firstNumber = testDataMap.get("transponderNumber");
        String lastNumber = String.valueOf(Integer.parseInt(firstNumber)+4);

        enterText(containerNumberInput, containerNumber);
        enterText(getLocator(genericLabelInput,"First Number"),firstNumber);
        enterText(getLocator(genericLabelInput,"Last Number"),lastNumber);
        clickElement(getLocator(genericSpan, "Next"));

        testDataMap.put("transponderNumber",String.valueOf(Integer.parseInt(lastNumber)+1));
        fileUtil.saveMapToFile(testDataMap, filePath);
    }

    public void selectAllTranspondersAndClickShipLater() {
        clickElement(selectAllCheckBox);
        clickElement(getLocator(genericButton, "Ship Later"));
    }
}