package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.abstract_pages.CartPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCartPageElements;

public class WbCartPage extends CartPage {

    public final static String PAGE_URL = "https://www.wildberries.ru/lk/basket";

    public WbCartPageElements wbCartPageElements;

    public WbCartPage(WebDriver webDriver) {
        super(webDriver, PAGE_URL);
        wbCartPageElements = new WbCartPageElements(webDriver);
        waitLoadElement(wbCartPageElements.defaultElements.changeCity.menu);
        super.cartPageElements = wbCartPageElements;
    }
}
