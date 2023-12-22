package org.ot5usk.wb;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ot5usk.WebDriverStarter;
import org.ot5usk.pages.wb_pages.WbCatalogPage;
import org.ot5usk.pages.wb_pages.WbMainPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbSearchBar;
import org.ot5usk.steps.assertions.wb_assertions.WbSearchBarAssertions;

import static org.ot5usk.steps.assertions.wb_assertions.WbSearchBarAssertions.query;

public class WbSearchBarTest extends WebDriverStarter {

    private WbSearchBar wbSearchBar;
    private WbCatalogPage wbCatalogPage;
    private WbSearchBarAssertions wbSbAsserts;

    @DisplayName("Using Wb search-bar")
    @Description("Тест-кейс 1: Работа с поисковой строкой")
    @Test
    void testWbSearchBar() {

        openPage();

        search(query);

        checkResultText();

        checkFirstFilter();

        checkSecondFilter();

        checkProductBrand();

        clickTheCross();

        checkClickTheCross();
    }

    @Step("Открытие страницы")
    void openPage() {
        WbMainPage wbMainPage = new WbMainPage(webDriver);
        wbSearchBar = wbMainPage.wbDefaultElements.wbSearchBar;
    }

    @Step("Выполнение поискового запроса")
    void search(String query) {
        wbSearchBar.clickOnTheSearchBar();
        wbSearchBar.enterQueryInSearchBar(query);
        wbCatalogPage = wbSearchBar.sendEnterKeyInSearchBar();
        wbSbAsserts = new WbSearchBarAssertions(wbCatalogPage);
    }

    @Step("Проверка результирующего текста")
    void checkResultText() {
        wbSbAsserts.checkResultText();
    }

    @Step("Проверка первого фильтра")
    void checkFirstFilter() {
        wbSbAsserts.checkFirstFilter();
    }

    @Step("Проверка второго фильтра")
    void checkSecondFilter() {
        wbSbAsserts.checkSecondFilter();
    }

    @Step("Проверка брэнда товара")
    void checkProductBrand() {
        wbSbAsserts.checkProductBrand();
    }

    @Step("Нажатие на крестик")
    void clickTheCross() {
        wbCatalogPage.wbCatalogPageElements.wbDefaultElements.wbSearchBar.clickTheCross();
    }

    @Step("Проверка наличия крестика")
    void checkClickTheCross() {
        wbSbAsserts.checkClickTheCross();
    }
}