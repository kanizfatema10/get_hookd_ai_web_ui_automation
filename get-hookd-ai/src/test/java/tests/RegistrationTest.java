package tests;

import java.time.LocalTime;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import model.UtilMethods;
import pages.RegistrationPage;

public class RegistrationTest extends Base {
    private RemoteWebDriver driver;
    private RegistrationPage registrationPage;

    @Test
    public void SignupTest() {

        int randomNumber = getCurrentTime();

        setRegistrationPageDriver();

        signup(randomNumber);

        String expectedUrlAfterSignup = "https://gethookdai.melioraweb.eu/login";
        String actualUrlAfterSignup = registrationPage.getLoginPageURL();

        Assert.assertEquals(expectedUrlAfterSignup, actualUrlAfterSignup);

        loginAfterSignup(randomNumber);

        String expectedUrlAfterLogin = "https://gethookdai.melioraweb.eu/verify-email";
        String actualUrlAfterLogin = registrationPage.getLoginPageURL();

        Assert.assertEquals(expectedUrlAfterLogin, actualUrlAfterLogin);

    }

    private void loginAfterSignup(int randomNumber) {
        registrationPage.setSignupEmail(randomNumber);
        UtilMethods.waitForSeconds(0.5);
        registrationPage.setSignupPassword();
        UtilMethods.waitForSeconds(0.5);
        registrationPage.clickOnSignupContinueButton();
        UtilMethods.waitForSeconds(3);
    }

    private void signup(int randomNumber) {
        registrationPage.openSignupPage();
        UtilMethods.waitForSeconds(0.5);
        registrationPage.clickOnModeChange();
        UtilMethods.waitForSeconds(0.5);
        registrationPage.clickOnSignupLink();
        UtilMethods.waitForSeconds(0.5);

        registrationPage.setSignupEmail(randomNumber);
        UtilMethods.waitForSeconds(0.5);
        registrationPage.setSignupPassword();
        UtilMethods.waitForSeconds(0.5);
        registrationPage.setSignupConfirmPassword();
        UtilMethods.waitForSeconds(0.5);

        registrationPage.clickOnSignupContinueButton();
        UtilMethods.waitForSeconds(3);
    }

    private void setRegistrationPageDriver() {
        driver = super.getActiveDriver();
        registrationPage = new RegistrationPage(driver);
    }

    private int getCurrentTime() {
        LocalTime now = LocalTime.now();
        return now.toSecondOfDay();
    }
}
