package org.ot5usk.wb;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.ot5usk.WebDriverStarter;
import org.ot5usk.pages.wb_pages.WbFlightsPage;
import org.ot5usk.pages.wb_pages.WbMainPage;
import org.ot5usk.steps.assertions.wb_assertions.WbFlightsAssertions;
import org.ot5usk.steps.search_data.SearchFlights;

import java.util.List;

public class WbFlightsTest extends WebDriverStarter {

    private List<WebElement> pathFilters;
    private WbMainPage wbMainPage;
    private WbFlightsPage wbFlightsPage;

    @DisplayName("Using Wb flights")
    @Description("Тест-кейс 5: Поиск авиабилетов")
    @Test
    void testWbCart() {

        initPathFilters();

        openPage();

        clickFiltersBtn();

        selectFilters();

        checkOpenedPage();

        fillFrom();

        fillTo();

        fillDate();

        ignoredBack();

        fillPassengers();

        clickSearchTicketsBtn();

        checkSearchResult();
    }

    @Step("Инициализация поискового пути")
    void initPathFilters() {
        pathFilters = new SearchFlights(webDriver).getSearchPathFilters();
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

    @Step("Проверка перехода на страницу")
    void checkOpenedPage() {
        WbFlightsAssertions.checkOpenedPage(webDriver);
        wbFlightsPage = new WbFlightsPage(webDriver);
    }

    @Step("Ввод данных в поле: Откуда")
    void fillFrom() {
        String from = "Домодедово";
        wbFlightsPage.fillFrom(from);
    }

    @Step("Ввод данных в поле: Куда")
    void fillTo() {
        String to = "Пулково";
        wbFlightsPage.fillTo(to);
    }

    @Step("Ввод данных в поле: Дата")
    void fillDate() {
        wbFlightsPage.fillDate();
    }

    @Step("Пропуск поля: Обратно")
    void ignoredBack() {
    }

    @Step("Выбор количества пассажиров")
    void fillPassengers() {
        wbFlightsPage.fillPassengers();
    }

    @Step("Нажатие кнопки: Найти билеты")
    void clickSearchTicketsBtn() {
        wbFlightsPage.clickSearchBtn();
    }

    @Step("Проверка отображаемого результата")
    void checkSearchResult() {
        WbFlightsAssertions.checkTicketsResult(webDriver);
    }
}
