package org.ot5usk.wb;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.ot5usk.WebDriverStarter;
import org.ot5usk.pages.wb_pages.WbCartPage;
import org.ot5usk.pages.wb_pages.WbCatalogPage;
import org.ot5usk.pages.wb_pages.WbMainPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCartPageElements;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.wb_assertions.WbCartAssertions;
import org.ot5usk.steps.assertions.wb_assertions.WbCatalogAssertions;
import org.ot5usk.steps.search_data.SearchVacuumsNdCleaners;

import java.util.List;

public class WbCartTest extends WebDriverStarter {

    private List<WebElement> pathFilters;
    private WbMainPage wbMainPage;
    private WbCatalogPage wbCatalogPage;
    private WbCatalogPageElements wbCatalogPageElements;
    private WbCartPageElements wbCartPageElements;

    @DisplayName("Using Wb cart")
    @Description("Тест-кейс 3: Добавление товара в корзину")
    @Test
    void testWbCart() {

        initPathFilters();

        openPage();

        clickFiltersBtn();

        selectFilters();

        checkCatalogTitleResult();

        checkPathFiltersLine();

        clickAddProductToCartBtn();

        checkCartCounterValue();

        checkCartCounterColor();

        clickToCartBtn();

        checkProductText();

        checkProductPrice();

        checkTotalPrice();

        checkOrderBtn();
    }

    @Step("Инициализация поискового пути")
    void initPathFilters() {
        pathFilters = new SearchVacuumsNdCleaners(webDriver).getSearchPathFilters();
    }

    @Step("Открытие страницы")
    void openPage() {
        wbMainPage = new WbMainPage(pathFilters, webDriver);
    }

    @Step("Нажатие кнопки: Фильтры")
    void clickFiltersBtn() {
        wbMainPage.wbDefaultElements.wbPathFilters.clickPathFiltersBtn();
    }

    @Step("Выбор фильтров")
    void selectFilters() {
        wbMainPage.wbDefaultElements.wbPathFilters.selectPathFilters();
    }

    @Step("Проверка результирующего заголовка")
    void checkCatalogTitleResult() {
        wbCatalogPage = new WbCatalogPage(webDriver);
        wbCatalogPageElements = wbCatalogPage.wbCatalogPageElements;
        WbCatalogAssertions.checkFiltersResult(wbCatalogPageElements);
    }

    @Step("Проверка пути фильтров")
    void checkPathFiltersLine() {
        WbCatalogAssertions.checkPathFilters(wbCatalogPageElements);
    }

    @Step("Нажатие кнопки: В корзину")
    void clickAddProductToCartBtn() {
        wbCatalogPage.addProductToCart();
    }

    @Step("Проверка значения счётчика количества товаров добавленных в корзину")
    void checkCartCounterValue() {
        WbCatalogAssertions.checkCartCounterValue(wbCatalogPageElements);
    }

    @Step("Проверка цвета счётчика количества товаров добавленных в корзину")
    void checkCartCounterColor() {
        WbCatalogAssertions.checkCartCounterColor(wbCatalogPageElements);
    }

    @Step("Нажатие кнопки: Корзина")
    void clickToCartBtn() {
        wbCatalogPage.clickToCartBtn();
    }

    @Step("Проверка текста товара")
    void checkProductText() {
        wbCartPageElements = new WbCartPage(webDriver).wbCartPageElements;
        WbCartAssertions.checkProductName(wbCatalogPageElements, wbCartPageElements);
    }

    @Step("Проверка цены товара")
    void checkProductPrice() {
        WbCartAssertions.checkProductPrice(wbCatalogPageElements, wbCartPageElements);
    }

    @Step("Проверка суммы: Итого")
    void checkTotalPrice() {
        WbCartAssertions.checkTotalProductPrice(wbCatalogPageElements, wbCartPageElements);
    }

    @Step("Проверка кнопки: Заказать")
    void checkOrderBtn() {
        WbCartAssertions.checkOrderBtn(wbCartPageElements);
    }
}
