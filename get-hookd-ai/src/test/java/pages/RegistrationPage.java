package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import model.CommonMethods;
import model.locators.LoginLocators;
import model.locators.RegistrationLocators;

public class RegistrationPage extends Base {
    private RemoteWebDriver driver;

    public RegistrationPage(RemoteWebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(this.driver);
    }

    public void openSignupPage() {
        driver.get(credentials.baseUrl);
    }

    public void clickOnSignupLink() {
        commonMethods.clickOnButton(RegistrationLocators.signupTextLink);
    }

    public void setSignupEmail(int randomNumber) {

        commonMethods.setText(RegistrationLocators.signupEmailField, "test" + randomNumber + "@yopmail.com");
    }

    public void setSignupPassword() {
        commonMethods.setText(RegistrationLocators.signuoPasswordField, "1234test");
    }

    public void setSignupConfirmPassword() {
        commonMethods.setText(RegistrationLocators.signupConfirmPasswordField, "1234test");
    }

    public void clickOnSignupContinueButton() {
        commonMethods.clickOnButton(RegistrationLocators.signupContinueButton);
    }

    public String getLoginPageURL() {
        return commonMethods.getCurrentPageURL();
    }

    public void clickOnModeChange() {
        commonMethods.clickOnButton(LoginLocators.modeChangeButtonfield);
    }
}
