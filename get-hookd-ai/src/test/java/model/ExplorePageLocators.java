package model;

import org.openqa.selenium.By;

public class ExplorePageLocators {
    public static By saveButtonOfTheFirstAd = By.xpath("//div[@class= 'ads-container']/div[2]/div[4]//button//span[contains(text(), 'Save')]");
    public static By selectBoardDropDownofTheFirstAd = By.xpath("//div[@class= 'ads-container']/div[2]/div[4]//div/div/div[2]/div[contains(@class, 'p-multiselect-label')]");
    public static By selectBoardOptionsContainer = By.xpath("//ul[contains(@class, 'p-multiselect-items')]");
    public static By selectBoardOptionElements = By.xpath(".//li[@data-pc-section='item']");
    public static By selectBoardDropdownOptionElement = By.xpath(".//li[@data-pc-section='item']//span");
}
