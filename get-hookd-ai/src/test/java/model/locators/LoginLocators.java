package model.locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static By modeChangeButtonfield = By.cssSelector("svg[stroke='currentColor']");
    public static By loginButtonField = By.cssSelector("a[href='/login']");
    public static By loginEmailField = By.cssSelector("[data-test='login-email']");
    public static By loginPasswordField = By.cssSelector("[data-test='login-password']");
    public static By continueButtonField = By.cssSelector("[data-test='login-submit']");

}
