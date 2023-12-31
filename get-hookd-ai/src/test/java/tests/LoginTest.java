package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import model.UtilMethods;
import pages.LoginPage;

public class LoginTest extends Base {

    private RemoteWebDriver driver;
    private LoginPage loginPage;

    // #region Test: Login Test
    @Test
    public void loginTest() {

        setLoginPageDriver();

        loginToGethookd();

        String expectedURL = "https://gethookdai.melioraweb.eu/swipe-file";
        String actualURL = loginPage.getHomePageURL();

        Assert.assertEquals(expectedURL, actualURL);

    }
    // #endregion

    private void loginToGethookd() {

        loginPage.openLoginPage();
        UtilMethods.waitForSeconds(0.5);

        // loginPage.clickOnModeChange();
        // UtilMethods.waitForSeconds(0.5);

        // loginPage.clickOnLogin();
        // UtilMethods.waitForSeconds(0.5);

        loginPage.setEmail(credentials.loginUserNameInputText);
        UtilMethods.waitForSeconds(0.5);

        loginPage.setPassword(credentials.loginPasswordInputText);
        UtilMethods.waitForSeconds(0.5);

        loginPage.clickOnContinue();
        UtilMethods.waitForSeconds(5);
    }

    private void setLoginPageDriver() {
        driver = super.getActiveDriver();
        loginPage = new LoginPage(driver);
    }

}
