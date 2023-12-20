package org.ot5usk.steps.scripts.wb_scripts;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbAdditionalFiltersPage;
import org.ot5usk.steps.tasks.cases.AdditionalFiltersCaseImpl;

public class WbAdditionalFiltersScript extends AdditionalFiltersCaseImpl {

    public WebDriver webDriver;
    public WbAdditionalFiltersPage wbAFiltersPage;
    public String productsBefore;
    public String productsAfter;

    public WbAdditionalFiltersScript(WebDriver webDriver, WbAdditionalFiltersPage wbAFiltersPage) {
        super(webDriver, wbAFiltersPage);
        this.webDriver = webDriver;
        this.wbAFiltersPage = wbAFiltersPage;
    }

    public void execute() {
        openSite();
        untilVisibilityOf(wbAFiltersPage.mainPage);
        clickFiltersBtn();
        selectFilters();
        clickAdditionalFiltersBtn();
        enterPrices("100000", "149000");
        rememberFoundProductsBefore();
        selectAdditionalFilters();
        rememberFoundProductsAfter();
    }

    public void rememberFoundProductsBefore() {
        productsBefore = wbAFiltersPage.foundProductsBefore.getText();
    }

    public void rememberFoundProductsAfter() {
        productsAfter = wbAFiltersPage.foundProductsAfter.getText();
    }
}
