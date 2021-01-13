package com.transcore.qa.mdtanoncore;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", plugin = {"pretty", "json:target/cucumber-report.json"},
        tags = "@MDTA_INV_Retailer_01")

public class MdtaNonCoreAutomationTests {
}