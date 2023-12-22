package org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.SearchBar;
import org.ot5usk.pages.wb_pages.WbCatalogPage;

public class WbSearchBar extends SearchBar  {

    private final WebDriver webDriver;

    @FindBy(xpath = "//*[contains(@id, 'searchInput')]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@aria-label, 'Очистить поиск')]")
    private WebElement cross;

    public WbSearchBar(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        super.searchInput = searchInput;
        super.cross = cross;
    }

    @Override
    public WbCatalogPage sendEnterKeyInSearchBar() {
        searchInput.sendKeys(Keys.ENTER);
        return new WbCatalogPage(webDriver);
    }
}
