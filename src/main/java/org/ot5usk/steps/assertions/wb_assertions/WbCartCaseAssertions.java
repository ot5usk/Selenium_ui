package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.WbCartPage;
import org.ot5usk.steps.assertions.CaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbCartScript;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WbCartCaseAssertions extends CaseAssertions {

    private final WbCartPage wbCartPage;
    private final WbCartScript wbCartScript;
    public String expectedFiltersResult = "Пылесосы и пароочистители";
    public String expectedCartCounterValue = "1";
    public String expectedCartCounterColor = "rgba(245, 81, 35, 1)";

    public WbCartCaseAssertions(WbCartPage wbCartPage, WbCartScript wbCartScript) {
        this.wbCartPage = wbCartPage;
        this.wbCartScript = wbCartScript;
    }

    public void checkFiltersResult() {
        checkElementText(expectedFiltersResult, wbCartScript.actualFiltersResult);
    }

    public void checkPathFilters() {
        String[] pathFiltersArr = wbCartScript.actualFiltersPath.split("\n");
        assertEquals(4, pathFiltersArr.length);
        assertEquals(pathFiltersArr[0], "Главная");
        assertEquals(pathFiltersArr[1], "Бытовая техника");
        assertEquals(pathFiltersArr[2], "Техника для дома");
        assertEquals(pathFiltersArr[3], "Пылесосы и пароочистители");
    }

    public void checkCartCounterValue() {
        checkElementText(expectedCartCounterValue, wbCartScript.actualCartCounterValue);

    }

    public void checkCartCounterColor() {
        checkElementText(expectedCartCounterColor, wbCartScript.actualCartCounterColor);
    }

    public void checkProductName() {
        List<String> productInCatalog = List.of(wbCartScript.productNameInCatalog, wbCartScript.productBrandInCatalog);
        List<String> result = new ArrayList<>();
        for (String s : productInCatalog) {
            List<String> temp = Arrays.stream(s.split(" ")).toList();
            temp = temp.stream().map(e -> e.replaceAll("[^A-Za-zА-Яа-я0-9]", "")).toList();
            temp = temp.stream().filter(e -> !e.isEmpty()).toList();
            result.addAll(temp);
        }
        for (String s : result) {
            assertTrue(wbCartScript.productNameInCart.contains(s));
        }
    }

    public void checkProductPrice() {
        assertDoesNotThrow(() -> wbCartScript.untilTextToBePresentInElement(wbCartPage.newProductPriceInCart, wbCartScript.newProductPriceInCatalog));
        assertDoesNotThrow(() -> wbCartScript.untilTextToBePresentInElement(wbCartPage.oldProductPriceInCart, wbCartScript.oldProductPriceInCatalog));
    }

    public void checkTotalProductPrice() {
        assertDoesNotThrow(() -> wbCartScript.untilTextToBePresentInElement(wbCartPage.newTotalProductPriceInCart, wbCartScript.newProductPriceInCatalog));
        assertDoesNotThrow(() -> wbCartScript.untilTextToBePresentInElement(wbCartPage.oldTotalProductPriceInCart, wbCartScript.oldProductPriceInCatalog));
    }

    public void checkOrderBtn() {
        assertDoesNotThrow(() -> wbCartScript.untilToBeClickable(wbCartPage.orderBtn));
    }
}
