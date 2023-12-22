package org.ot5usk.wb;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.ot5usk.WebDriverStarter;
import org.ot5usk.pages.wb_pages.WbCatalogPage;
import org.ot5usk.pages.wb_pages.WbMainPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.wb_assertions.WbBottomFiltersAssertions;
import org.ot5usk.steps.search_data.SearchLaptops;

import java.util.List;

public class WbBottomFiltersTest extends WebDriverStarter {

    private List<WebElement> pathFilters;
    private List<WebElement> bottomFilters;
    private List<WebElement> bottomInputFilters;
    private WbMainPage wbMainPage;
    private WbCatalogPageElements wbCatalogPageElements;
    private String counterBeforeUseBf;

    @DisplayName("Using Wb bottom filters")
    @Description("Тест-кейс 4: Работа с фильтрами")
    @Test
    void testWbCart() {

        initPathFilters();

        openPage();

        clickFiltersBtn();

        selectFilters();

        checkOpenedPage();

        clickBottomFiltersMenuBtn();

        selectBottomFilters();

        clickShowBtn();

        checkFiltersChoice();

        checkProductsCounter();

        checkFiltersDisplay();

        checkResetBtn();
    }

    @Step("Инициализация поискового пути, фильтров")
    void initPathFilters() {
        SearchLaptops searchLaptops = new SearchLaptops(webDriver);
        pathFilters = searchLaptops.getSearchPathFilters();
        bottomFilters = searchLaptops.getBottomFilters();
        bottomInputFilters = searchLaptops.getBottomInputFilters();
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

    @Step("Проверка открытия страницы")
    void checkOpenedPage() {
        WbCatalogPage wbCatalogPage = new WbCatalogPage(webDriver, bottomFilters, bottomInputFilters);
        wbCatalogPageElements = wbCatalogPage.wbCatalogPageElements;
        WbBottomFiltersAssertions.checkOpenedPage(wbCatalogPageElements);
    }

    @Step("Открытие меню фильтров")
    void clickBottomFiltersMenuBtn() {
        wbCatalogPageElements.wbFilters.clickBottomFiltersMenu();
    }

    @Step("Применение фильтров")
    void selectBottomFilters() {
        counterBeforeUseBf = wbCatalogPageElements.wbFilters.productsCounterInBFMenu.getText();
        wbCatalogPageElements.wbFilters.fillBottomInputFilters("100000", "149000");
        wbCatalogPageElements.wbFilters.selectBottomFilters();
    }

    @Step("Нажатие кнопки: Показать")
    void clickShowBtn() {
        wbCatalogPageElements.wbFilters.clickApplyBottomFiltersBtn();
    }

    @Step("Проверка активации выбранных фильтров")
    void checkFiltersChoice() {
        WbBottomFiltersAssertions.checkFilterActivity(counterBeforeUseBf, wbCatalogPageElements);
    }

    @Step("Проверка счётчика количества товаров на странице")
    void checkProductsCounter() {
        WbBottomFiltersAssertions.checkProductsCounter(webDriver, wbCatalogPageElements);
    }

    @Step("Проверка отображения выбранных фильтров")
    void checkFiltersDisplay() {
        WbBottomFiltersAssertions.checkDisplayOfFilters(webDriver, wbCatalogPageElements);
    }

    @Step("Проверка наличия кнопки: Сбросить всё")
    void checkResetBtn() {
        WbBottomFiltersAssertions.checkVisibilityOfResetBtn(wbCatalogPageElements);
    }
}
