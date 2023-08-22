package model;

import org.openqa.selenium.By;

public class LoginLocators {
    public static By modeChangeButtonfield = By.cssSelector("svg[stroke='currentColor']");
    public static By loginButtonField = By.cssSelector("a[href='/login']");
    public static By loginEmailField = By.cssSelector("input[placeholder='Your email']");
    public static By loginPasswordField = By.cssSelector("input[placeholder='Password']");
    public static By continueButtonField = By.xpath("//button/span[contains(text(),'Continue')]");

}
