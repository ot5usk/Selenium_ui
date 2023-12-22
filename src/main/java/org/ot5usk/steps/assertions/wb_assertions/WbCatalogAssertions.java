package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.WbAssertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WbCatalogAssertions extends WbAssertions {

    public static String[] expectedPathFilters = {"Главная", "Бытовая техника", "Техника для дома", "Пылесосы и пароочистители"};
    public static String expectedFiltersResult = "Пылесосы и пароочистители";
    public static String expectedCartCounterValue = "1";
    public static String expectedCartCounterColor = "rgba(245, 81, 35, 1)";

    public static void checkFiltersResult(WbCatalogPageElements catalogElements) {
        checkElementText(expectedFiltersResult, catalogElements.catalogTitleIfUsedPathFilters.getText());
    }

    public static void checkPathFilters(WbCatalogPageElements catalogElements) {
        String[] pathFiltersArr = catalogElements.pathFiltersList.getText().split("\n");
        assertEquals(expectedPathFilters.length, pathFiltersArr.length);
        assertTrue(Arrays.toString(pathFiltersArr).contains(Arrays.toString(expectedPathFilters)));
    }

    public static void checkCartCounterValue(WbCatalogPageElements catalogElements) {
        checkElementText(expectedCartCounterValue, catalogElements.cartCounter.getText());

    }

    public static void checkCartCounterColor(WbCatalogPageElements catalogElements) {
        checkElementText(expectedCartCounterColor, catalogElements.cartCounter.getCssValue("background-color"));
    }
}
