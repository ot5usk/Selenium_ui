package org.ot5usk.wb;

import jdk.jfr.Description;
import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbCartPage;
import org.ot5usk.steps.assertions.wb_assertions.WbCartCaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbCartScript;
import org.ot5usk.utils.WebDriverStarter;

@Log
public class WbCartCaseTest {

    private static WebDriverStarter webDriverStarter;
    private static WbCartPage wbCartPage;
    private static WbCartScript wbCartScript;
    private static WbCartCaseAssertions wbCartCaseAsserts;

    public static void prepare() {
        webDriverStarter = new WebDriverStarter();
        WebDriver webDriver = webDriverStarter.on();
        wbCartPage = new WbCartPage(webDriver);
        wbCartScript = new WbCartScript(webDriver, wbCartPage);
    }

    @DisplayName("Using Wb cart")
    @BeforeAll
    static void execute() {
        prepare();
        wbCartScript.execute();
        wbCartCaseAsserts = new WbCartCaseAssertions(wbCartPage, wbCartScript);
    }

    @DisplayName("Filters result")
    @Description("Отображается: Пылесосы и пароочистители")
    @Test
    void testFiltersResult() {
        wbCartCaseAsserts.checkFiltersResult();
    }

    @DisplayName("Filter path")
    @Description("Путь фильтра: Главная - Бытовая техника - Техника для дома - Пылесосы и пароочистители")
    @Test
    void testPathFilters() {
        wbCartCaseAsserts.checkPathFilters();
    }

    @DisplayName("Cart counter value")
    @Description("В правом верхнем углу над логотипом Корзина цифра 1")
    @Test
    void testCartCounterValue() {
        wbCartCaseAsserts.checkCartCounterValue();
    }

    @DisplayName("Cart counter color")
    @Description("В правом верхнем углу над логотипом Корзина красная цифра")
    @Test
    void testCartCounterColor() {
        wbCartCaseAsserts.checkCartCounterColor();
    }

    @DisplayName("Product name from previous steps")
    @Description("Текст соответствует названию товара из предыдущих шагов")
    @Test
    void testProductName() {
        wbCartCaseAsserts.checkProductName();
    }

    @DisplayName("Product price from previous steps")
    @Description("Цена товара соответствует цене товара из предыдущих шагов")
    @Test
    void testProductPrice() {
        wbCartCaseAsserts.checkProductPrice();
    }

    @DisplayName("Total price")
    @Description("Итого = сумме товара")
    @Test
    void testTotalProductPrice() {
        wbCartCaseAsserts.checkTotalProductPrice();
    }

    @DisplayName("Order btn activity")
    @Description("Кнопка Заказать активна для нажатия")
    @Test
    void testOrderBtn() {
        wbCartCaseAsserts.checkOrderBtn();
    }

    @AfterAll
    static void exit() {
        webDriverStarter.off();
    }
}
