package model.locators;

import org.openqa.selenium.By;

public class RegistrationLocators {
    public static By signupTextLink = By.xpath("//div//a[2][contains(text(), 'Sign up')]");
    public static By signupEmailField = By.cssSelector("input[placeholder='Your email']");
    public static By signuoPasswordField = By.cssSelector("input[placeholder='Password']");
    public static By signupConfirmPasswordField = By.cssSelector("input[placeholder='Confirm password']");
    public static By signupContinueButton = By.xpath("//button/span[contains(text(), 'Continue')]");
}
