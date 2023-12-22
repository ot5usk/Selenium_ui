package org.ot5usk.steps.assertions.wb_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbFlightsPage;
import org.ot5usk.steps.assertions.WbAssertions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WbFlightsAssertions extends WbAssertions {

    public static String expectedUrl = WbFlightsPage.PAGE_URL;

    public static void checkOpenedPage(WebDriver webDriver) {
        checkElementText(expectedUrl, webDriver.getCurrentUrl());
    }

    public static void checkTicketsResult(WebDriver webDriver) {
        try {
            long countTickets = webDriver.findElements(By.cssSelector("div[class*='_tickets-module__list']")).size();
            assertTrue(countTickets > 0);
        } catch (Exception e) {
            String emptyTicketsListMsg = webDriver.findElement(By.xpath("//h1[text()='Мы не нашли билеты по вашему запросу']")).getText();
            assertFalse(emptyTicketsListMsg.isEmpty());
        }
    }
}
