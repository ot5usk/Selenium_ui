package org.ot5usk.pages.abstract_pages.abstract_pages_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.CatalogPage;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.Filters;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.DefaultElements;

public abstract class CatalogPageElements extends CatalogPage {

    public DefaultElements defaultElements;

    public Filters filters;

    public WebElement catalogPage;

    public WebElement pathFiltersList;

    public WebElement catalogTitleIfUsedPathFilters;

    public WebElement catalogTitleIfUsedSearchBar;

    public WebElement productsCounter;

    public WebElement firstProduct;

    public WebElement addToCartBtn;

    public WebElement cartCounter;

    public WebElement toCartBtn;

    public WebElement productName;

    public WebElement productBrand;

    public WebElement newProductPrice;

    public WebElement oldProductPrice;

    public CatalogPageElements(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
}
