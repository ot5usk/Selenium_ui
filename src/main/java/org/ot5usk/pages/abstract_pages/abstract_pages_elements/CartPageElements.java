package org.ot5usk.pages.abstract_pages.abstract_pages_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.CartPage;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.abstract_default_pages_elements.DefaultElements;

public abstract  class CartPageElements extends CartPage {

    public DefaultElements defaultElements;

    public WebElement productName;

    public WebElement newProductPrice;

    public WebElement oldProductPrice;

    public WebElement newTotalProductPrice;

    public WebElement oldTotalProductPrice;

    public WebElement orderBtn;

    public CartPageElements(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
}
