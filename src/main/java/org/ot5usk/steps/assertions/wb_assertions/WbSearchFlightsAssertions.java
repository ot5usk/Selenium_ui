package org.ot5usk.steps.assertions.wb_assertions;

import org.openqa.selenium.By;
import org.ot5usk.steps.assertions.CaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbSearchFlightsScript;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WbSearchFlightsAssertions extends CaseAssertions {

    private final WbSearchFlightsScript wbSfScript;

    public WbSearchFlightsAssertions(WbSearchFlightsScript wbSfScript) {
        this.wbSfScript = wbSfScript;
    }

    public void checkOpenedPage() {
        checkElementText("https://vmeste.wildberries.ru/avia",wbSfScript.actualUrl);
    }

    public void checkTickets() {
        try {
            long countTickets = wbSfScript.webDriver.findElements(By.xpath("//div[@class='_1701943856481__tickets-module__list--3BBxo']")).size();
            assertTrue(countTickets > 0);
        } catch (Exception e) {
            String emptyTicketsListMsg = wbSfScript.webDriver.findElement(By.xpath("//h1[text()='Мы не нашли билеты по вашему запросу']")).getText();
            assertFalse(emptyTicketsListMsg.isEmpty());
        }
    }
}
