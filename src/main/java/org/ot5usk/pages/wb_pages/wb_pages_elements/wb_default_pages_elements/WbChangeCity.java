package org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.ChangeCity;

public class WbChangeCity extends ChangeCity {

    @FindBy(xpath = "//li[contains(@class, 'simple-menu__item j-geocity-wrap')]")
    public WebElement menu;

    @FindBy(xpath = "//input[contains(@placeholder, 'Введите адрес')]")
    public WebElement searchBar;

    @FindBy(xpath = "//ymaps[@class='ymaps-2-1-79-searchbox-list-button']")
    public WebElement searchBarMenu;

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

    public WbChangeCity(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        super.menu = menu;
        super.searchBar = searchBar;
        super.firstAddress = firstAddress;
        super.infoBlock = infoBlock;
        super.infoBlockAddress = infoBlockAddress;
        super.selectBtn = selectBtn;
        super.resultAddress = resultAddress;
    }

    @Override
    public void enterQueryInChangeCitySearchBar(String searchQuery) {
        super.enterQueryInChangeCitySearchBar(searchQuery);
        searchBarMenu.click();
        searchBar.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
    }
}
