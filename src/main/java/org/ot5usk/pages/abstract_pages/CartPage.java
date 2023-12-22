package org.ot5usk.pages.abstract_pages;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.CartPageElements;

public abstract class CartPage extends Page {

    public CartPageElements cartPageElements;

    public CartPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
}
