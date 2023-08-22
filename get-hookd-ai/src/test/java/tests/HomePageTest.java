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

    @Test(priority = 1)
    public void createNewFolderTest() {
        setHomePageDriver();
        setLoginPageDriver();
        loginToGethookd();

        //createNewFolder(1);
        createNewFolder();


        String expectedFolderName = "Knz Test";

        // Find all folder elements within the folder list
        List<WebElement> folderElements = homePage.findFolderElements();

        boolean folderFound = false;

        // Loop through folder elements and check for the expected folder name
        for (WebElement folderElement : folderElements) {
            String folderText = folderElement.getText();
            if (folderText.contains(expectedFolderName)) {
                folderFound = true;
                break;
            }
        }

        Assert.assertTrue(folderFound, "Folder '" + expectedFolderName + "' not found.");

        UtilMethods.waitForSeconds(1);
        homePage.scrollDowntoCreatedFolder();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnMoreOptionsButton();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnDeleteButton();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnDeleteConfirmationButton();
        UtilMethods.waitForSeconds(3);


    }

    // End of folder creation test

    @Test(priority = 2)
    public void createNewBoardTest() {
        setHomePageDriver();
        setLoginPageDriver();

        loginToGethookd();

        createNewFolder();

        homePage.scrollDowntoCreatedFolder();
        UtilMethods.waitForSeconds(2);
        homePage.clickOnAddNewBoardButton();
        UtilMethods.waitForSeconds(1);
        homePage.setBoardName();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnCreateBoardButton();
        UtilMethods.waitForSeconds(2);
        homePage.clickOnCreatedFolder();
        UtilMethods.waitForSeconds(5);

        WebElement createdBoardElement = homePage.findCreadBoard();

        String expectedBoardName = "Test board";
        String actualBoardName = createdBoardElement.getText();

        Assert.assertEquals(expectedBoardName,actualBoardName);

        UtilMethods.waitForSeconds(1);
        homePage.clickOnMoreOptionsButton();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnDeleteButton();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnDeleteConfirmationButton();
        UtilMethods.waitForSeconds(3);


    }

    // common methods for all tests

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
