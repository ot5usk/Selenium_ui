package org.ot5usk.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverStarter {

    private WebDriver webDriver;

    public WebDriver on() {
        webDriver = BrowserUtil.getBrowserSessionFactory().openBrowserSession();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        webDriver.manage().window().setSize(new Dimension(1920, 1080));
        return webDriver;
    }

    public void off() {
        webDriver.quit();
    }
}
