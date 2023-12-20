package org.ot5usk.steps.tasks.cases;

public interface AdditionalFiltersCase extends Case {

    void clickFiltersBtn();

    void selectFilters();

    void clickAdditionalFiltersBtn();

    void enterPrices(String... prices);

    void selectAdditionalFilters();
}
