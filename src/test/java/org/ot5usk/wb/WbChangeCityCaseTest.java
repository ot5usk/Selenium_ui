package org.ot5usk.wb;

import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbChangeCityPage;
import org.ot5usk.steps.assertions.wb_assertions.WbChangeCityCaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbChangeCityScript;
import org.ot5usk.utils.WebDriverStarter;

@Log
public class WbChangeCityCaseTest {

    private static WebDriverStarter webDriverStarter;
    private static WbChangeCityScript wbChangeCityScript;
    private static WbChangeCityCaseAssertions wbChangeCityAsserts;

    @DisplayName("Using Wb change-city-search-bar")
    @BeforeAll
    static void execute() {
        webDriverStarter = new WebDriverStarter();
        WebDriver webDriver = webDriverStarter.on();
        WbChangeCityPage wbChangeCityPage = new WbChangeCityPage(webDriver);
        wbChangeCityScript = new WbChangeCityScript(webDriver, wbChangeCityPage);
        wbChangeCityScript.execute();
        wbChangeCityAsserts = new WbChangeCityCaseAssertions(wbChangeCityPage);
    }

    @DisplayName("Info block")
    @Description("Открылась информация о центре выдачи")
    @Test
    void testInfoBlock() {
        wbChangeCityAsserts.checkInfoBlock(wbChangeCityScript.infoBlockIsDisplayed);
    }

    @DisplayName("First address")
    @Description("Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов")
    @Test
    void testFirstAddress() {
        wbChangeCityAsserts.checkFirstAddress(wbChangeCityScript.expectedFirstAddress, wbChangeCityScript.actualFirstAddress);
    }

    @DisplayName("Url transition")
    @Description("Произошел переход на главную страницу WB ")
    @Test
    void testUrl() {
        wbChangeCityAsserts.checkUrl(wbChangeCityScript.currentUrl);
    }

    @DisplayName("Previous step value")
    @Description("Отображается адрес пункта выдачи из предыдущего шага")
    @Test
    void testResultAddress() {
        wbChangeCityAsserts.checkResultAddress();
    }

    @AfterAll
    static void exit() {
        webDriverStarter.off();
    }
}
