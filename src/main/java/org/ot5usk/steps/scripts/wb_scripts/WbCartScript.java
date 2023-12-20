package org.ot5usk.steps.scripts.wb_scripts;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbCartPage;
import org.ot5usk.steps.tasks.cases.CartCaseImpl;

public class WbCartScript extends CartCaseImpl {

    public WebDriver webDriver;
    public WbCartPage wbCartPage;

    public String actualFiltersResult;
    public String actualFiltersPath;

    public String actualCartCounterValue;
    public String actualCartCounterColor;

    public String productNameInCatalog;
    public String productBrandInCatalog;
    public String newProductPriceInCatalog;
    public String oldProductPriceInCatalog;

    public String productNameInCart;
    public String newTotalProductPriceInCart;
    public String oldTotalProductPriceInCart;

    public WbCartScript(WebDriver webDriver, WbCartPage wbCartPage) {
        super(webDriver, wbCartPage);
        this.webDriver = webDriver;
        this.wbCartPage = wbCartPage;
    }

    public void execute() {
        openSite();
        untilVisibilityOf(wbCartPage.mainPage);
        clickFiltersBtn();
        selectFilters();
        rememberActualFiltersResults();
        rememberProductInCatalog();
        addProductToCart();

        rememberCartCounter();
        clickToCartBtn();

        rememberProductNameCart();
        rememberTotalProductPriceInCart();
    }

    public void rememberActualFiltersResults() {
        actualFiltersResult = wbCartPage.filtersResult.getText();
        actualFiltersPath = wbCartPage.pathFilters.getText();
    }

    public void rememberCartCounter() {
        actualCartCounterValue = wbCartPage.cartCounter.getText();
        actualCartCounterColor = wbCartPage.cartCounter.getCssValue("background-color");
    }

    public void rememberProductInCatalog() {
        productNameInCatalog = wbCartPage.productNameInCatalog.getText();
        productBrandInCatalog = wbCartPage.productBrandInCatalog.getText();
        newProductPriceInCatalog = wbCartPage.newProductPriceInCatalog.getText();
        oldProductPriceInCatalog = wbCartPage.oldProductPriceInCatalog.getText();
    }

    public void rememberProductNameCart() {
        productNameInCart = wbCartPage.productNameInCart.getText();
    }

    public void rememberTotalProductPriceInCart() {
        newTotalProductPriceInCart = wbCartPage.newTotalProductPriceInCart.getText();
        oldTotalProductPriceInCart = wbCartPage.oldTotalProductPriceInCart.getText();
    }
}
