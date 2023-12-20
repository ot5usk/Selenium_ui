package org.ot5usk.wb;

import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbSearchBarPage;
import org.ot5usk.steps.assertions.wb_assertions.WbSearchBarCaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbSearchBarScript;
import org.ot5usk.utils.WebDriverStarter;

@Log
public class WbSearchBarCaseTest {

    private static WebDriverStarter webDriverStarter;
    private static WbSearchBarPage wbSearchBarPage;
    private static  WbSearchBarScript wbSearchBarScript;
    private static WbSearchBarCaseAssertions wbSbCaseAsserts;

    public static void prepare() {
        webDriverStarter = new WebDriverStarter();
        WebDriver webDriver = webDriverStarter.on();
        wbSearchBarPage = new WbSearchBarPage(webDriver);
        wbSearchBarScript = new WbSearchBarScript(webDriver, wbSearchBarPage);
    }

    @DisplayName("Using Wb search-bar")
    @BeforeAll
    static void execute() {
        prepare();
        wbSearchBarScript.execute();
        wbSbCaseAsserts = new WbSearchBarCaseAssertions(wbSearchBarPage);
    }

    @DisplayName("Search result text")
    @Description("Присутствует текст: По запросу Iphone 13 найдено")
    @Test
    void testResultText() {
        wbSbCaseAsserts.checkResultText();
    }

    @DisplayName("First filter")
    @Description("Первый фильтр - iphone 13")
    @Test
    void testFirstFilter() {
        wbSbCaseAsserts.checkFirstFilter();
    }

    @DisplayName("Second filter")
    @Description("Применен фильтр - По популярности")
    @Test
    void testSecondFilter() {
        wbSbCaseAsserts.checkSecondFilter();
    }

    @DisplayName("Product brand")
    @Description("У первого устройства из списка бренд - Apple")
    @Test
    void testProductBrand() {
        wbSbCaseAsserts.checkProductBrand();
    }

    @DisplayName("Click the cross")
    @Description("Строка поиска стала пустой")
    @Test //значение searchInput всегда пустое, я так и не понял(если !Очень в кратце), поэтому проверяю крестик
    void testClickTheCross() {
        wbSbCaseAsserts.checkClickTheCross();
    }

    @AfterAll
    static void exit() {
        webDriverStarter.off();
    }
}
