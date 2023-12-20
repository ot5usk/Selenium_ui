package org.ot5usk.wb;

import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbSearchFlightsPage;
import org.ot5usk.steps.assertions.wb_assertions.WbSearchFlightsAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbSearchFlightsScript;
import org.ot5usk.utils.WebDriverStarter;

@Log
public class WbSearchFlightsCaseTest {

    private static WebDriverStarter webDriverStarter;
    private static WbSearchFlightsScript wbSfScript;
    private static WbSearchFlightsAssertions wbSfAsserts;

    public static void prepare() {
        webDriverStarter = new WebDriverStarter();
        WebDriver webDriver = webDriverStarter.on();
        WbSearchFlightsPage wbSfPage = new WbSearchFlightsPage(webDriver);
        wbSfScript = new WbSearchFlightsScript(webDriver, wbSfPage);
    }

    @DisplayName("Using Wb search flights")
    @BeforeAll
    static void execute() {
        prepare();
        wbSfScript.execute();
        wbSfAsserts = new WbSearchFlightsAssertions(wbSfScript);
    }

    @DisplayName("Url transition")
    @Description("Произошел переход на страницу https://vmeste.wildberries.ru/avia")
    @Test
    void testOpenedPage() {
        wbSfAsserts.checkOpenedPage();
    }

    @DisplayName("Tickets result")
    @Description("Если билеты найдены: есть хотя бы один билет в списке, иначе отображается сообщение о том, что билеты не найдены")
    @Test
    void testSearchResult() {
        wbSfAsserts.checkTickets();
    }

    @AfterAll
    static void exit() {
        webDriverStarter.off();
    }

}
