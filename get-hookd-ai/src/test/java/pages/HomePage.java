package pages;

import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

import base.Base;
import model.CommonMethods;
import model.HomePageLocators;

public class HomePage extends Base {
    RemoteWebDriver driver;
    CommonMethods commonMethods;


    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(this.driver);
    }

    public void clickOnAddNewFolderButton(){
        commonMethods.clickOnButton(HomePageLocators.addNewFolderButton);
    }

    public void setNewFolderName(){
        commonMethods.setText(HomePageLocators.folderNameField, "Test");
    }

    public void clickOnCreateFolderButton(){
        commonMethods.clickOnButton(HomePageLocators.createFolderbutton);
    }

    public List<WebElement> findFolderElements(){
        return driver.findElements(HomePageLocators.folderElements);
    }

}
