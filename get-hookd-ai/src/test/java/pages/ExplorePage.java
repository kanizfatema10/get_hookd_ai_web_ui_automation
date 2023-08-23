package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import model.CommonMethods;
import model.ExplorePageLocators;

public class ExplorePage {

    RemoteWebDriver driver;
    CommonMethods commonMethods;


    public ExplorePage(RemoteWebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(this.driver);
    }

    public void clickOnSaveButton(){
        commonMethods.clickOnButton(ExplorePageLocators.saveButtonOfTheFirstAd);
    }

    public void clickOnSelectBoardDropDown(){
        commonMethods.clickOnButton(ExplorePageLocators.selectBoardDropDownofTheFirstAd);
    }

    public WebElement findSelectBoardOptionsContainer(){
        return driver.findElement(ExplorePageLocators.selectBoardOptionsContainer);
    }

    public List<WebElement> findSelectBoardOptionElements(WebElement dropdownList){
        return dropdownList.findElements(ExplorePageLocators.selectBoardOptionElements);
    }

    public String findSelectBoardDropdownOptionName(WebElement optionElement){
        return optionElement.findElement(By.tagName("span")).getText();
    }
    
}
