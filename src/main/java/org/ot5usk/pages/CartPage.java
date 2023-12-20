package org.ot5usk.pages;

import org.openqa.selenium.WebElement;

public abstract class CartPage extends BaseFiltersPage {

    public WebElement filtersResult;
    public WebElement pathFilters;
    public WebElement firstProduct;
    public WebElement addToCartBtn;
    public WebElement cartCounter;
    public WebElement toCartBtn;

    public CartPage(String url) {
        super(url);
    }
}
