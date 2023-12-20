package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.WbSearchBarPage;
import org.ot5usk.steps.assertions.CaseAssertions;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WbSearchBarCaseAssertions extends CaseAssertions {

    private final WbSearchBarPage searchBarPage;

    public static String query = "Iphone 13";

    public static String expectedResult = "Iphone 13"; //изначально хотели: По запросу Iphone 13 найдено
    public static String expectedFirstFilter = "Iphone 13";
    public static String expectedSecondFilter = "По популярности";
    public static String expectedProductBrand = "Apple";

    public WbSearchBarCaseAssertions(WbSearchBarPage wbPage) {
        this.searchBarPage = wbPage;
    }

    public void checkResultText() {
        String actualResult = searchBarPage.resultingTextElement.getText();
        checkElementText(expectedResult,actualResult);
    }

    public void checkFirstFilter() {
        String actualFirstFilter = searchBarPage.firstFilterElement.getText();
        checkElementText(expectedFirstFilter, actualFirstFilter);
    }

    public void checkSecondFilter() {
        String actualSecondFilter = searchBarPage.secondFilterElement.getText();
        checkElementText(expectedSecondFilter, actualSecondFilter);
    }

    public void checkProductBrand() {
        String actualProductBrand = searchBarPage.productBrandElement.getText();
        checkElementText(expectedProductBrand, actualProductBrand);
    }

    public void checkClickTheCross() {
        assertFalse(searchBarPage.cross.isDisplayed());
    }
}
