package model;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By addNewFolderButton = By.xpath("//div[contains(text(),'New folder')]/parent::div/button");
    public static By folderNameField = By.id("folder-name");
    public static By createFolderbutton = By.xpath("//button/span[contains(text(), 'Create folder')]");
    public static By folderElements = By.xpath("//div[contains(@class, 'folder-list')]/descendant::div[@class='text-sm font-normal']");
    
}
