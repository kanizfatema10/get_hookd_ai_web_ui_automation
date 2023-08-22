package model;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By addNewFolderButton = By.xpath("//div[contains(text(),'New folder')]/parent::div/button");
    public static By folderNameField = By.id("folder-name");
    public static By createFolderButton = By.xpath("//button/span[contains(text(), 'Create folder')]");
    public static By folderElements = By.xpath("//div[contains(@class, 'folder-list')]/descendant::div[@class='text-sm font-normal']");
    public static By createdFolder = By.xpath("//div[contains(@class, 'folder-list')]/descendant::div[@class='text-sm font-normal'][contains(text(), 'Knz Test')]");
    public static By addNewBoardButton = By.xpath("//div[contains(text(), 'Knz Test')]/parent::div/parent::div/div[2]/button");
    public static By createBoardButton = By.xpath("//button/span[contains(text(), 'Create board')]");
    public static By createdBoard = By.xpath("//div[contains(text(), 'Knz Test')]/parent::div/../parent::div/../div[2]//div[@class = 'w-full text-sm']");
    public static By moreOptionsButtonOfTheCreatedFolder = By.xpath("//div[contains(text(), 'Knz Test')]/parent::div/parent::div/div[2]/button/parent::div/div//button");
    public static By deleteButtonOfTheCreatedFolder = By.xpath("//div[contains(text(), 'Knz Test')]/parent::div/../parent::div/div/div[2]/div//ul//li[2]//div[contains(text(), 'Delete')]");
    public static By deleteConfirmationButton = By.xpath("//div[contains(text(),'Are you sure want to delete')]/parent::div//button");

    
}
