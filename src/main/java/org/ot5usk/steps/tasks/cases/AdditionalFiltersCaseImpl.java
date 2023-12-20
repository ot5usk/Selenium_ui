package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.AdditionalFiltersPage;
import org.ot5usk.steps.tasks.BaseFiltersWorkerImpl;

public class AdditionalFiltersCaseImpl extends BaseFiltersWorkerImpl implements AdditionalFiltersCase {

    public AdditionalFiltersPage aFiltersPage;
    public BaseFiltersWorkerImpl baseFiltersWorker;

    public AdditionalFiltersCaseImpl(WebDriver webDriver, AdditionalFiltersPage additionalFiltersPage) {
        super(webDriver, additionalFiltersPage);
        baseFiltersWorker = new BaseFiltersWorkerImpl(webDriver, additionalFiltersPage);
        this.aFiltersPage = additionalFiltersPage;
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
    public void clickAdditionalFiltersBtn() {
        clickOnTheElement(aFiltersPage.additionalFiltersBtn);
    }

    @Override
    public void enterPrices(String... prices) {
        WebElement from = aFiltersPage.additionalFilters.get(0);
        WebElement to = aFiltersPage.additionalFilters.get(1);
        from.clear();
        to.clear();
        enterTextInElement(from, prices[0]);
        enterTextInElement(to, prices[1]);
    }

    @Override
    public void selectAdditionalFilters() {
        WebElement filter;
        long numOfFilters = aFiltersPage.additionalFilters.size();
        for (int i = 0; i < numOfFilters; i++) {
            filter = aFiltersPage.additionalFilters.get(i);
            waitLoadElement(filter);
            untilVisibilityOf(filter);
            untilToBeClickable(filter);
            moveToElement(filter);
            clickOnTheElement(filter);
        }
        clickOnTheElement(aFiltersPage.executeAdditionalFiltersBtn);
    }
}
