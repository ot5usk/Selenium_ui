package org.ot5usk.pages.abstract_pages;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.CatalogPageElements;
import org.ot5usk.pages.abstract_pages.methods.CatalogMethods;

public abstract class CatalogPage extends Page  implements CatalogMethods {

    public CatalogPageElements catalogPageElements;

    public CatalogPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public void addProductToCart() {
        untilVisibilityOf(catalogPageElements.catalogPage);
        untilToBeClickable(catalogPageElements.firstProduct);
        moveToElement(catalogPageElements.firstProduct);
        clickOnTheElement(catalogPageElements.addToCartBtn);
    }

    @Override
    public void clickToCartBtn() {
        untilToBeClickable(catalogPageElements.toCartBtn);
        clickOnTheElement(catalogPageElements.toCartBtn);
    }
}
