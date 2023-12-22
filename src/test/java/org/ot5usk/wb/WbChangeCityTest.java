package org.ot5usk.wb;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ot5usk.WebDriverStarter;
import org.ot5usk.pages.wb_pages.WbMainPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbChangeCity;
import org.ot5usk.steps.assertions.wb_assertions.WbChangeCityAssertions;

import static org.ot5usk.steps.assertions.wb_assertions.WbChangeCityAssertions.query;

public class WbChangeCityTest extends WebDriverStarter {

    private WbMainPage wbMainPage;
    private WbChangeCity wbChangeCity;
    private final WbChangeCityAssertions wbChCityAsserts = new WbChangeCityAssertions();
    private String expectedAddress;

    @DisplayName("Using Wb change-city")
    @Description("Тест-кейс 2: Смена города")
    @Test
    void testWbChangeCity() {

        openPage();

        clickChangeCityBtn();

        enterSearchQuery(query);

        selectFirstAddress();

        checkInfoBlock();

        checkAddress();

        clickSelectBtn();

        checkUrl();

        checkResultAddress();
    }

    @Step("Открытие страницы")
    void openPage() {
        wbMainPage = new WbMainPage(webDriver);
    }

    @Step("Нажатие кнопки смены города")
    void clickChangeCityBtn() {
        wbChangeCity = wbMainPage.wbDefaultElements.wbChangeCity;
        wbChangeCity.clickOnTheChangeCityBtn();
    }

    @Step("Выполнение поискового запроса")
    void enterSearchQuery(String searchQuery) {
        wbChangeCity.enterQueryInChangeCitySearchBar(searchQuery);
    }

    @Step("Выбор первого адреса из результирующего списка")
    void selectFirstAddress() {
        expectedAddress = wbChangeCity.firstAddress.getText();
        wbChangeCity.selectFirstAddress();
    }

    @Step("Проверка наличия информации о центре выдачи")
    void checkInfoBlock() {
        boolean infoBlockIsDisplayed = wbChangeCity.infoBlock.isDisplayed();
        wbChCityAsserts.checkInfoBlock(infoBlockIsDisplayed);
    }

    @Step("Проверка адреса пункта выдачи")
    void checkAddress() {
        String actualAddress = wbChangeCity.firstAddress.getText();
        wbChCityAsserts.checkAddress(expectedAddress, actualAddress);
    }

    @Step("Нажатие кнопки выбора")
    void clickSelectBtn() {
        wbChangeCity.clickSelectBtn();
    }

    @Step("Проверка перехода на главную страницу")
    void checkUrl() {
        String actualUrl = webDriver.getCurrentUrl();
        wbChCityAsserts.checkUrl("https://www.wildberries.ru/", actualUrl);
    }

    @Step("Проверка отображаемого адреса")
    void checkResultAddress() {
        wbMainPage = new WbMainPage(webDriver);
        wbChCityAsserts.checkResultAddress(wbMainPage.wbDefaultElements.wbChangeCity.resultAddress.getText());
    }
}
