package manager;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class BaseHelper {
    Logger logger = LoggerFactory.getLogger(BaseHelper.class);


    WebDriver driver;

    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        System.out.println(locator);
        return driver.findElement(locator);
    }

    private List <WebElement> findElementsBase(By locator){
        System.out.println(locator);
        return driver.findElements(locator);
    }

    public void clickBase(By locator){
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator){
        WebElement el = findElementBase(locator);
        return el.getText().toUpperCase();
    }

    public void typeTextBase(By locator, String text){
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isElementExist(By locator) {
        return findElementsBase(locator).size() > 0;
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();
        return isTextEqualGet2Strings(expectedResult, actualResult);
    }
        public void jsClickBase(String locator) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(locator);
        }

        public void clickByXY(By locator, double down ,int right){ // 10 12
            Rectangle rectangle = findElementBase(locator).getRect();
            int x = rectangle.getX() + (rectangle.getWidth() /right);
            int y = (int) (rectangle.getY() +  (rectangle.getHeight() /down));

            Actions actions = new Actions(driver);
            actions.moveByOffset(x,y).click().perform();

        }

    public boolean isTextEqualGet2Strings(String expectedResult, String actualResult){
        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult +
                    "actual result: " + actualResult);
        }
        return false;
    }

    public void pushEnter() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN).build().perform();
    }

    public String getTextAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText().toUpperCase().trim();
    }

    }

