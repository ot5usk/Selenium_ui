package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.CartPage;
import org.ot5usk.steps.DefaultMethods;
import org.ot5usk.steps.tasks.BaseFiltersWorkerImpl;

public class CartCaseImpl extends DefaultMethods implements CartCase {

    public CartPage cartPage;
    public BaseFiltersWorkerImpl baseFiltersWorker;

    public CartCaseImpl(WebDriver webDriver, CartPage cartPage) {
        super(webDriver, cartPage);
        baseFiltersWorker = new BaseFiltersWorkerImpl(webDriver, cartPage);
        this.cartPage = cartPage;
    }

    @Override
    public void clickFiltersBtn() {
        baseFiltersWorker.clickBaseFiltersBtn();
    }

    @Override
    public void selectFilters() {
        baseFiltersWorker.selectBaseFilters();
    }

    @Override
    public void addProductToCart() {
        untilToBeClickable(cartPage.firstProduct);
        moveToElement(cartPage.firstProduct);
        clickOnTheElement(cartPage.addToCartBtn);
    }

    @Override
    public void clickToCartBtn() {
        untilToBeClickable(cartPage.toCartBtn);
        clickOnTheElement(cartPage.toCartBtn);
    }
}
