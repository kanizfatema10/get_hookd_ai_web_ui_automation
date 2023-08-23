package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CommonMethods {

    private RemoteWebDriver driver;

    public CommonMethods(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void setText(By fieldText, String inputText) {
        driver.findElement(fieldText).sendKeys(inputText);
    }

    public void clickOnButton(By btnLocator) {
        driver.findElement(btnLocator).click();
    }

    public String getCurrentPageTile() {
        return driver.getTitle();
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public void scrollDown(By targetElement) {
        WebElement element = driver.findElement(targetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
