package org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.Page;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.DefaultElements;

import java.util.List;

public class WbDefaultElements extends DefaultElements {

    public WbChangeCity wbChangeCity;
    public WbSearchBar wbSearchBar;
    public WbPathFilters wbPathFilters;

    public WbDefaultElements(WebDriver webDriver, Page page) {
        wbChangeCity = new WbChangeCity(webDriver);
        wbPathFilters = new WbPathFilters(page);
        wbSearchBar = new WbSearchBar(webDriver);
        super.changeCity = wbChangeCity;
        super.pathFilters = wbPathFilters;
        super.searchBar = wbSearchBar;
    }

    public WbDefaultElements(WebDriver webDriver, Page page, List<WebElement> pathFilters) {
        this(webDriver, page);
        wbPathFilters = new WbPathFilters(page, pathFilters);
    }
}
