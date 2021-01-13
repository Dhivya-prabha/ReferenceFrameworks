package com.transcore.qa.mdtanoncore.pages;

import com.github.javafaker.Faker;
import com.transcore.qa.mdtanoncore.transferobjects.TestContextTO;
import com.transcore.qa.mdtanoncore.util.FileUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class BasePage extends PageObject {

    @Managed
    public static WebDriver driver;

    @Value("${container.number}")
    String containerNumber;

    @Value("${testdata.filepath}")
    String filePath;

    @Autowired
    FileUtil fileUtil;

    @Autowired
    TestContextTO testContextTO;

    static final String STATE_CODE = "MD";

    By genericSpan = By.xpath("//span[contains(text(),'XXX')]");
    By genericAnchor = By.xpath("//a[contains(text(),'XXX')]");
    By genericDiv = By.xpath("//div[contains(text(),'XXX')]");
    By genericTab = By.xpath("//ul[@class='panel-header']/descendant::a[contains(text(),'XXX')]");
    By genericWindow = By.xpath("//md-dialog//h2[contains(text(),'XXX')]");
    By genericPage = By.xpath("//p[contains(text(),'XXX')]");
    By genericLabelInput = By.xpath("//label[contains(text(),'XXX')]/following-sibling::input");
    By genericH4 = By.xpath("//h4[contains(text(),'XXX')]");
    By genericH2 = By.xpath("//h2[text()='XXX']");
    By genericPara = By.xpath("//p[contains(text(),'XXX')]");
    By genericText = By.xpath("//input[@id='XXX']");
    By genericButton = By.xpath("//*[contains(text(),'XXX')]/parent::button");
    By genericLabelDropdown = By.xpath("//label[contains(text(),'XXX')]/following-sibling::md-select");
    By genericDropdownOption = By.xpath("//md-option/div[contains(text(),'XXX')]");

    By toastDiv = By.xpath("//div[@class='md-toast-content']");
    By nextButton = By.xpath("//span[contains(text(),'NEXT')]");
    By logOut = By.xpath(" //*[@ng-click='$ctrl.onLogOut()']");
    By filterButton = By.xpath("//button[text()='Filter']");
    By actionOptions = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'XXX')]");
    By containerNumberInput = By.xpath("//input[@name='txtBEContainerNumber']");
    By selectAllCheckBox = By.xpath("//md-checkbox[@id='selectAll']");
    By poFilterLink = By.xpath("//a[contains(text(),'XXX')]/preceding-sibling::a");
    By poNumberInput = By.xpath("//input[@id='txtFilter_orderNumber']");

    public void openBrowser(String url) {
        log.info("Opening browser with Url : {}", url);
        driver = getDriver();
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    public void quitDriver() {
        driver.quit();
    }

    public void logOut() {
        waitForElement(5, logOut);
        clickElement(logOut);
    }

    public void checkElementPresence(By locator) {
        waitForElement(20, locator);
        boolean isPresent = !driver.findElements(locator).isEmpty();
        if (isPresent) {
            log.info("The element {} is present", locator.toString());
        } else {
            log.error("The element {} is NOT present", locator.toString());
        }
        Serenity.takeScreenshot();
        Assert.assertTrue(locator.toString() + " NOT is present", isPresent);
    }

    public void checkTabDisplay(String tabName) {
        pageLoad(10);
        checkElementPresence(getLocator(genericTab, tabName));
    }

    public void checkWindowDisplay(String windowName) {
        pageLoad(10);
        checkElementPresence(getLocator(genericWindow, windowName));
    }

    public void checkSpanDisplay(String spanName) {
        pageLoad(10);
        checkElementPresence(getLocator(genericSpan, spanName));
    }

    public void validateToastMessage(String toastMessage) {
        waitForElement(10, toastDiv);
        Assert.assertEquals("Toast message " + toastMessage + " is not displayed", toastMessage, getElement(toastDiv).getText());
    }

    protected WebElement getElementFromGenericLocator(By genericLocator, String textToSearchFor) {
        return driver.findElement(getLocator(genericLocator, textToSearchFor));
    }

    public static By getLocator(By genericLocator, String replaceString) {
        String elementDescription = genericLocator.toString().substring(genericLocator.toString().lastIndexOf(": ") + 2, genericLocator.toString().length());
        elementDescription = elementDescription.replaceFirst("XXX", replaceString);
        if (genericLocator.toString().contains("xpath:"))
            return By.xpath(elementDescription);
        return null;
    }

    public static void pageLoad(int pageLoadTimeout) {
        new WebDriverWait(driver, pageLoadTimeout).until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void next() {
        waitForElement(nextButton).click();
    }

    public static void waitForVisibilityToBeClickableByLocator(int timeInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForInvisibilityByLocator(int timeInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement pollForElement(int timeInSeconds, By locator) {
        for (int i = 0; i < timeInSeconds; i++) {
            if (!driver.findElements(locator).isEmpty()) {
                return driver.findElement(locator);
            }
            waitSeconds(1);
        }
        return null;
    }

    public WebElement waitForElement(int timeInSeconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        for (int i = 0; i < 5; i++) {
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (webElement.isEnabled()) {
                waitSeconds(1);
                return webElement;
            }
        }
        return null;
    }

    public WebElement waitForElement(By locator) {
        return waitForElement(20, locator);
    }

    protected void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error("Exception: ", e);
        }
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(String buttonName) {
        clickElement(getLocator(genericSpan, buttonName));
    }

    public void clickLink(String linkName) {
        clickElement(getLocator(genericAnchor, linkName));
    }

    protected void clickElement(By locator) {
        try {
            waitForElement(locator).click();
        } catch (Exception e) {
            clickElementWithAction(locator);
        }
    }

    protected void clickElementWithAction(By locator) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(locator)).click().perform();
        } catch (Exception e) {
            clickElementWithJsExecutor(locator);
        }
    }

    protected void clickElementWithJsExecutor(By locator) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (Exception e) {
            log.error("Exception: ", e);
        }
    }

    protected void enterText(By locator, String text) {
        try {
            waitForElement(locator).clear();
            waitForElement(locator).sendKeys(text);
        } catch (Exception e) {
            log.error("Exception: ", e);
        }
    }

    protected void actionShortCutKeys(Keys actionKey, String... chars) {
        Actions action = new Actions(driver);
        action.sendKeys(actionKey, String.join("", chars)).perform();
    }

    protected String getRandomPhone() {
        String random1 = String.valueOf(new Random().nextInt((999 - 200) + 1) + 200);
        String random2 = String.valueOf(new Random().nextInt((999 - 200) + 1) + 200);
        String random3 = String.valueOf(new Random().nextInt((9999 - 2000) + 1) + 2000);
        return random1 + random2 + random3;
    }

    public void checkElementNotPresent(By locator) {
        boolean isNotPresent = driver.findElements(locator).isEmpty();
        if (isNotPresent) {
            log.info("The element {} is not present", locator.toString());
        } else {
            log.error("The element {} is PRESENT", locator.toString());
        }
        Serenity.takeScreenshot();
        Assert.assertTrue(locator.toString() + " is present", isNotPresent);
    }

    public void checkMenuElementDisplay(String pText) {
        checkElementPresence(getLocator(genericPara, pText));
    }

    public void checkMenuElementNotDisplay(String pText) {
        checkElementNotPresent(getLocator(genericPara, pText));
    }

    public void clickMenuElement(String pText) {
        clickElement(getLocator(genericPara, pText));
    }

    public void checkLinkDisplay(String aText) {
        checkElementPresence(getLocator(genericAnchor, aText));
    }

    protected void actionMoveToElement(WebElement ele) {
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

    protected static String getRandomName(String nameType) {
        Faker faker = new Faker(new Locale("en-US"));
        String name = "";
        for (int i = 0; i < 30; i++) {
            name = "FIRST".equalsIgnoreCase(nameType) ? faker.name().firstName() : faker.name().lastName();
            if (name.length() > 4 && name.length() < 7) {
                break;
            }
        }
        return name;
    }

    public void checkLinkNotDisplay(String aText) {
        checkElementNotPresent(getLocator(genericAnchor, aText));
    }

    public void checkTextDisplay(String aText) {
        checkElementPresence(getLocator(genericDiv, aText));
    }

    public void checkButtonElement(String buttonName) {
        checkElementPresence(getLocator(genericSpan, buttonName));
    }

    protected void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            log.error("Exception: ", e);
        }
    }

    protected void switchToFrame(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
        } catch (Exception e) {
            log.error("Exception: ",e);
        }
    }

    protected void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            log.error("Exception: ",e);
        }
    }

    public void clickButtonElement(String buttonName) { clickElement(getLocator(genericSpan, buttonName)); }

    public void checkElementNotEnabled(By locator) {
        boolean isNotEnabled = driver.findElement(locator).isEnabled();
        if(!isNotEnabled) {
            log.info("The element {} is not enabled", locator.toString());
        } else {
            log.error("The element {} is ENABLED", locator.toString());
        }
        Serenity.takeScreenshot();
        Assert.assertFalse(locator.toString() +" is not enabled",isNotEnabled);
    }

}