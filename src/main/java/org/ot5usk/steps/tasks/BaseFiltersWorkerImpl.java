package org.ot5usk.steps.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.BaseFiltersPage;
import org.ot5usk.steps.DefaultMethods;

public class BaseFiltersWorkerImpl extends DefaultMethods implements BaseFiltersWorker {

    private final BaseFiltersPage baseFiltersPage;

    public BaseFiltersWorkerImpl(WebDriver webDriver, BaseFiltersPage baseFiltersPage) {
        super(webDriver, baseFiltersPage);
        this.baseFiltersPage = baseFiltersPage;
    }

    @Override
    public void clickBaseFiltersBtn() {
        clickOnTheElement(baseFiltersPage.baseFiltersBtn);
    }

    @Override
    public void selectBaseFilters() {
        WebElement filter;
        long numOfFilters = baseFiltersPage.baseFilters.size();
        long lastFilter = baseFiltersPage.baseFilters.size() - 1;
        for (int i = 0; i < numOfFilters; i++) {
            filter =  baseFiltersPage.baseFilters.get(i);
            waitLoadElement(filter);
            untilVisibilityOf(filter);
            untilToBeClickable(filter);
            moveToElement(filter);
            try {
                if (i != lastFilter) {
                    WebElement nextFilter = baseFiltersPage.baseFilters.get(i + 1);
                    untilVisibilityOf(nextFilter);
                    continue;
                }
                clickOnTheElement(filter);
            } catch (Exception e) {
                clickOnTheElement(filter);
            }
        }
    }
}
