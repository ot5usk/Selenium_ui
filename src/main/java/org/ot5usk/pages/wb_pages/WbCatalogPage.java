package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.CatalogPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;

import java.util.List;

public class WbCatalogPage extends CatalogPage {

    public final static String PAGE_URL = "https://www.wildberries.ru/catalog";

    public WbCatalogPageElements wbCatalogPageElements;

    public WbCatalogPage(WebDriver webDriver) {
        super(webDriver, PAGE_URL);
        wbCatalogPageElements = new WbCatalogPageElements(webDriver);
        super.catalogPageElements = wbCatalogPageElements;
        waitLoadElement(wbCatalogPageElements.wbDefaultElements.wbPathFilters.btn);
    }

    public WbCatalogPage(WebDriver webDriver, List<WebElement> bottomFilters, List<WebElement> inputBottomFilters) {
        this(webDriver);
        wbCatalogPageElements = new WbCatalogPageElements(webDriver, bottomFilters, inputBottomFilters);
    }
}
