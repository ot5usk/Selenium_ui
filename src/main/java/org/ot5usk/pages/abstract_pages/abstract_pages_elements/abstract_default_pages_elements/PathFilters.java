package org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements;

import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.Page;
import org.ot5usk.pages.abstract_pages.methods.PathFiltersMethods;

import java.util.List;

public abstract class PathFilters extends Filters implements PathFiltersMethods {

    private final Page page;
    public WebElement btn;

    private List<WebElement> path;

    public PathFilters(Page page) {
        super(page.webDriver, page.url);
        this.page = page;
    }

    public void setPath(List<WebElement> path) {
        this.path = path;
    }

    @Override
    public void clickPathFiltersBtn() {
        page.clickOnTheElement(btn);
    }

    @Override
    public void selectPathFilters() {
        WebElement filter;
        long numOfFilters = path.size();
        long lastFilter = path.size() - 1;
        for (int i = 0; i < numOfFilters; i++) {
            filter = path.get(i);
            page.waitLoadElement(filter);
            page.untilVisibilityOf(filter);
            page.untilToBeClickable(filter);
            page.moveToElement(filter);
            try {
                if (i != lastFilter) {
                    WebElement nextFilter = path.get(i + 1);
                    page.untilVisibilityOf(nextFilter);
                    continue;
                }
                page.clickOnTheElement(filter);
            } catch (Exception e) {
                page.clickOnTheElement(filter);
            }
        }
    }
}
