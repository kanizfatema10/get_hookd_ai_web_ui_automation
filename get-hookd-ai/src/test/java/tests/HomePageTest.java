package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import model.Credentials;
import model.UtilMethods;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {
    RemoteWebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    Credentials credentials = new Credentials();

    @Test
    public void createNewFolderTest() {
        setHomePageDriver();
        setLoginPageDriver();
        loginToGethookd();

        createNewFolder();

        String expectedFolderName = "Test"; 

        // Find all folder elements within the folder list
        List<WebElement> folderElements = homePage.findFolderElements();

        boolean folderFound = false;

        // Loop through folder elements and check for the expected folder name
        for (WebElement folderElement : folderElements) {
            String folderText = folderElement.getText();
            if (folderText.contains(expectedFolderName)) {
                folderFound = true;
                break; // Exit loop if folder is found
            }
        }

        // Assert that the expected folder name was found
        Assert.assertTrue(folderFound, "Folder '" + expectedFolderName + "' not found.");
    }



    private void createNewFolder() {
        homePage.clickOnAddNewFolderButton();
        homePage.setNewFolderName();
        homePage.clickOnCreateFolderButton();
        UtilMethods.waitForSeconds(5);
    }

    

    public void setHomePageDriver() {
        driver = super.getActiveDriver();
        homePage = new HomePage(driver);
    }

    private void loginToGethookd() {

        loginPage.openLoginPage();
        UtilMethods.waitForSeconds(0.5);

        loginPage.clickOnModeChange();
        UtilMethods.waitForSeconds(0.5);

        loginPage.clickOnLogin();
        UtilMethods.waitForSeconds(0.5);

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
