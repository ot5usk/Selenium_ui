package org.ot5usk;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.ot5usk.utils.BrowserUtil;

import java.time.Duration;

public class WebDriverStarter {

    public static WebDriver webDriver;

    @BeforeAll
    public static void on() {
        webDriver = BrowserUtil.getBrowserSessionFactory().openBrowserSession();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        webDriver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterAll
    public static void off() {
        webDriver.quit();
    }
}
