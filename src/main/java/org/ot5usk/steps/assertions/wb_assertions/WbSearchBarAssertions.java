package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.WbCatalogPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.WbAssertions;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class WbSearchBarAssertions extends WbAssertions {

    private final WbCatalogPageElements elements;
    public static String query = "Iphone 13";
    public static String expectedResult = "Iphone 13";
    public static String expectedFirstTopFilter = "Iphone 13";
    public static String expectedSecondTopFilter = "По популярности";
    public static String expectedProductBrand = "Apple";

    public WbSearchBarAssertions(WbCatalogPage wbCatalogPage) {
        this.elements = wbCatalogPage.wbCatalogPageElements;
    }

    public void checkResultText() {
        String actualResult = elements.catalogTitleIfUsedSearchBar.getText();
        checkElementText(expectedResult, actualResult);
    }

    public void checkFirstFilter() {
        String actualFirstFilter = elements.filters.topFilters.get(0).getText();
        checkElementText(expectedFirstTopFilter, actualFirstFilter);
    }

    public void checkSecondFilter() {
        String actualSecondFilter = elements.filters.topFilters.get(1).getText();
        checkElementText(expectedSecondTopFilter, actualSecondFilter);
    }

    public void checkProductBrand() {
        String actualProductBrand = elements.productBrand.getText();
        checkElementText(expectedProductBrand, actualProductBrand);
    }

    public void checkClickTheCross() {
        assertFalse(elements.defaultElements.searchBar.cross.isDisplayed());
    }
}
