package org.ot5usk.wb;

import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbAdditionalFiltersPage;
import org.ot5usk.steps.assertions.wb_assertions.WbAdditionalFiltersCaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbAdditionalFiltersScript;
import org.ot5usk.utils.WebDriverStarter;

@Log
public class WbAdditionalFiltersCaseTest {

    private static WebDriverStarter webDriverStarter;
    private static WbAdditionalFiltersPage wbAFiltersPage;
    private static WbAdditionalFiltersScript wbAFiltersScript;
    private static WbAdditionalFiltersCaseAssertions aFiltersCaseAsserts;

    public static void prepare() {
        webDriverStarter = new WebDriverStarter();
        WebDriver webDriver = webDriverStarter.on();
        wbAFiltersPage = new WbAdditionalFiltersPage(webDriver);
        wbAFiltersScript = new WbAdditionalFiltersScript(webDriver, wbAFiltersPage);
    }

    @DisplayName("Using Wb additional filters")
    @BeforeAll
    static void execute() {
        prepare();
        wbAFiltersScript.execute();
        aFiltersCaseAsserts = new WbAdditionalFiltersCaseAssertions(wbAFiltersPage, wbAFiltersScript);
    }

    @DisplayName("Opened page")
    @Description("Открылась страница с ноутбуками")
    @Test
    void testOpenedPage() {
        aFiltersCaseAsserts.checkOpenedPage();
    }

    @DisplayName("Filters activity")
    @Description("Фильтр активировался")
    @Test
    void testFilterActivity() {
        aFiltersCaseAsserts.checkFilterActivity();
    }

    @DisplayName("Number of products")
    @Description("Значение счётчика отображаемого на странице = количеству товаров на странице ")
    @Test
    void testNumberOfProducts() {
        aFiltersCaseAsserts.checkProductCount();
    }

    @DisplayName("Filters choices")
    @Description("Выбранные фильтры отображаются на странице")
    @Test
    void testChoice() {
        aFiltersCaseAsserts.checkDisplayOfFilters();
    }

    @DisplayName("Reset btn")
    @Description("Появилась кнопка Сбросить все")
    @Test
    void testResetBtn() {
        aFiltersCaseAsserts.checkVisibilityOfResetBtn();
    }

    @AfterAll
    static void exit() {
        webDriverStarter.off();
    }
}
