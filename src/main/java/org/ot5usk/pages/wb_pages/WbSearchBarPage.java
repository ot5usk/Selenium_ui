package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.SearchBarPage;

public class WbSearchBarPage extends SearchBarPage {

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    @FindBy(xpath = "//*[contains(@id, 'searchInput')]")
    public WebElement searchBar;

    @FindBy(xpath = "//button[contains(@aria-label, 'Очистить поиск')]")
    public WebElement cross;

    @FindBy (xpath = "//*[contains(@class, 'catalog-page')]")
    public WebElement catalogPage;

    @FindBy(xpath = "//*[contains(@class, 'searching-results__title')]")
    public WebElement resultingTextElement;

    @FindBy(xpath = "//button[contains(@class, 'dropdown-filter__btn dropdown-filter__btn--burger')]")
    public WebElement firstFilterElement;

    @FindBy(xpath = "//button[contains(@class, 'dropdown-filter__btn dropdown-filter__btn--sorter')]")
    public WebElement secondFilterElement;

    @FindBy(xpath = "//span[contains(@class, 'product-card__brand')]")
    public WebElement productBrandElement;

    public WbSearchBarPage(WebDriver webDriver) {
        super("https://www.wildberries.ru/");
        PageFactory.initElements(webDriver, this);
        super.searchBar = searchBar;
        super.cross = cross;
    }
}