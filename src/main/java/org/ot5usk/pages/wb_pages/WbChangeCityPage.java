package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.ChangeCityPage;

public class WbChangeCityPage extends ChangeCityPage {

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    @FindBy(xpath = "//li[contains(@class, 'simple-menu__item j-geocity-wrap')]")
    public WebElement changeCityMenu;

    @FindBy(xpath = "//input[contains(@placeholder, 'Введите адрес')]")
    public WebElement changeCitySearchBar;

    @FindBy(xpath = "//span[contains(@class, 'address-item__name-text')]")
    public WebElement firstAddress;

    @FindBy(xpath = "//*[contains(@class, 'geo-block__info-wrap')]")
    public WebElement infoBlock;

    @FindBy(xpath = "//*[contains(@class, 'details-self__name-text')]")
    public WebElement infoBlockAddress;

    @FindBy(xpath = "//*[contains(@class, 'details-self__btn btn-main')]")
    public WebElement selectBtn;

    @FindBy(xpath = "//span[contains(@data-wba-header-name, 'DLV_Adress')]")
    public WebElement resultAddress;

    public WbChangeCityPage(WebDriver webDriver) {
        super("https://www.wildberries.ru/");
        PageFactory.initElements(webDriver, this);
        super.changeCityMenu = changeCityMenu;
        super.changeCitySearchBar = changeCitySearchBar;
        super.firstAddress = firstAddress;
        super.selectBtn = selectBtn;
    }
}
