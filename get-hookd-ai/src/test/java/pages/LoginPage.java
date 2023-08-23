package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import model.CommonMethods;
import model.locators.LoginLocators;

public class LoginPage extends Base {

    private RemoteWebDriver driver;

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(this.driver);
    }

    public void openLoginPage() {
        driver.get(credentials.baseUrl);
    }

    public void setEmail(String loginUserName) {
        commonMethods.setText(LoginLocators.loginEmailField, loginUserName);
    }

    public void setPassword(String loginPassword) {
        commonMethods.setText(LoginLocators.loginPasswordField, loginPassword);
    }

    public void clickOnModeChange() {
        commonMethods.clickOnButton(LoginLocators.modeChangeButtonfield);
    }

    public void clickOnLogin() {
        commonMethods.clickOnButton(LoginLocators.loginButtonField);
    }

    public void clickOnContinue() {
        commonMethods.clickOnButton(LoginLocators.continueButtonField);
    }

    public String getHomePageURL() {
        return commonMethods.getCurrentPageURL();
    }

}
