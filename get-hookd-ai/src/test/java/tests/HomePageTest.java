package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import model.UtilMethods;
import pages.ExplorePage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {

    private RemoteWebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ExplorePage explorePage;

    // #region Test-1: folder creation
    @Test(priority = 1)
    public void createNewFolderTest() {
        setHomePageDriver();
        setLoginPageDriver();
        loginToGethookd();

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

        deleteFolder();
    }
    // #endregion

    // #region Test-2: board creation
    @Test(priority = 2)
    public void createNewBoardTest() {
        setHomePageDriver();
        setLoginPageDriver();

        loginToGethookd();
        createNewFolder();
        createBoard();

        WebElement createdBoardElement = homePage.findCreadBoard();
        String expectedBoardName = "Test board";
        String actualBoardName = createdBoardElement.getText();
        Assert.assertEquals(expectedBoardName, actualBoardName);

        deleteFolder();
    }
    // #endregion

    // #region Test-3: save ad to created board
    @Test(priority = 3)
    public void saveAdToBoardTest() {
        setHomePageDriver();
        setLoginPageDriver();
        setExplorePageDriver();

        loginToGethookd();
        createNewFolder();
        createBoard();

        homePage.clickOnExploreMenu();
        UtilMethods.waitForSeconds(1);
        explorePage.clickOnSelectBoardDropDown();
        UtilMethods.waitForSeconds(1);

        String expectedOption = "Test board";
        // Find the dropdown list
        WebElement dropdownList = explorePage.findSelectBoardOptionsContainer();
        // Find all option elements within the dropdown list
        List<WebElement> optionElements = explorePage.findSelectBoardOptionElements(dropdownList);
        // Iterate through the option elements
        for (WebElement optionElement : optionElements) {
            String optionText = optionElement.findElement(By.tagName("span")).getText();
            // Check if the option text matches the expected option
            if (optionText.equals(expectedOption)) {
                optionElement.click();
                break;
            }
        }

        UtilMethods.waitForSeconds(1);
        explorePage.clickOnSaveButton();
        UtilMethods.waitForSeconds(1);

        // Check if the ad is being saved at the selected board
        homePage.scrollDowntoCreatedFolder();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnCreatedFolder();
        UtilMethods.waitForSeconds(1);
        homePage.clickOnCreatedBoard();
        UtilMethods.waitForSeconds(2);

        // Locate the ad within the board's content
        WebElement adElement = homePage.findAdElement();

        // Assert that the ad is present on the board
        Assert.assertNotNull(adElement, "Ad was not added to the board.");
    }
    // #endregion

    // #region common methods

    private void setLoginPageDriver() {
        driver = super.getActiveDriver();
        loginPage = new LoginPage(driver);
    }

    public void setHomePageDriver() {
        driver = super.getActiveDriver();
        homePage = new HomePage(driver);
    }

    public void setExplorePageDriver() {
        driver = super.getActiveDriver();
        explorePage = new ExplorePage(driver);
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
        UtilMethods.waitForSeconds(3);
    }

    private void createNewFolder() {
        homePage.clickOnAddNewFolderButton();
        UtilMethods.waitForSeconds(0.5);
        homePage.setNewFolderName();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnCreateFolderButton();
        UtilMethods.waitForSeconds(2);
    }

    private void deleteFolder() {
        UtilMethods.waitForSeconds(0.5);
        homePage.scrollDowntoCreatedFolder();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnMoreOptionsButton();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnDeleteButton();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnDeleteConfirmationButton();
        UtilMethods.waitForSeconds(2);
    }

    private void createBoard() {
        homePage.scrollDowntoCreatedFolder();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnAddNewBoardButton();
        UtilMethods.waitForSeconds(0.5);
        homePage.setBoardName();
        UtilMethods.waitForSeconds(0.5);
        homePage.clickOnCreateBoardButton();
        UtilMethods.waitForSeconds(2);
        homePage.clickOnCreatedFolder();
        UtilMethods.waitForSeconds(2);
    }

    // #endregion

}
