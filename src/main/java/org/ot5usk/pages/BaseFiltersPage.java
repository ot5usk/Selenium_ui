package org.ot5usk.pages;

import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BaseFiltersPage extends Page {

    public WebElement baseFiltersBtn;
    public List<WebElement> baseFilters;

    public BaseFiltersPage(String url) {
        super(url);
    }
}
