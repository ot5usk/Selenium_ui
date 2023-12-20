package org.ot5usk.pages;

import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class AdditionalFiltersPage extends BaseFiltersPage {

    public WebElement additionalFiltersBtn;
    public List<WebElement> additionalFilters;
    public WebElement executeAdditionalFiltersBtn;

    public AdditionalFiltersPage(String url) {
        super(url);
    }
}
