package pages;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

import base.Base;
import model.CommonMethods;
import model.locators.BoardPageLocators;
import model.locators.HomePageLocators;

public class HomePage extends Base {

    private RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(this.driver);
    }

    public void clickOnAddNewFolderButton() {
        commonMethods.clickOnButton(HomePageLocators.addNewFolderButton);
    }

    public void setNewFolderName() {
        commonMethods.setText(HomePageLocators.folderNameField, "Knz Test");
    }

    public void clickOnCreateFolderButton() {
        commonMethods.clickOnButton(HomePageLocators.createFolderButton);
    }

    public List<WebElement> findFolderElements() {
        return driver.findElements(HomePageLocators.folderElements);
    }

    public void scrollDowntoCreatedFolder() {
        commonMethods.scrollDown(HomePageLocators.createdFolder);
    }

    public void clickOnAddNewBoardButton() {
        commonMethods.clickOnButton(HomePageLocators.addNewBoardButton);
    }

    public void setBoardName() {
        commonMethods.setText(HomePageLocators.folderNameField, "Test board");
    }

    public void clickOnCreateBoardButton() {
        commonMethods.clickOnButton(HomePageLocators.createBoardButton);
    }

    public void clickOnCreatedFolder() {
        commonMethods.clickOnButton(HomePageLocators.createdFolder);
    }

    public WebElement findCreadBoard() {
        return driver.findElement(HomePageLocators.createdBoardElement);
    }

    public void clickOnMoreOptionsButton() {
        commonMethods.clickOnButton(HomePageLocators.moreOptionsButtonOfTheCreatedFolder);
    }

    public void clickOnDeleteButton() {
        commonMethods.clickOnButton(HomePageLocators.deleteButtonOfTheCreatedFolder);
    }

    public void clickOnDeleteConfirmationButton() {
        commonMethods.clickOnButton(HomePageLocators.deleteConfirmationButton);
    }

    public void clickOnExploreMenu() {
        commonMethods.clickOnButton(HomePageLocators.exploreMenu);
    }

    public void clickOnCreatedBoard() {
        commonMethods.clickOnButton(HomePageLocators.createdBoardElement);
    }

    public WebElement findAdElement() {
        return driver.findElement(BoardPageLocators.addedAd);
    }

}
