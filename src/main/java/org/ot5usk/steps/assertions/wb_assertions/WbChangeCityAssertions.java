package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.steps.assertions.WbAssertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WbChangeCityAssertions extends WbAssertions {

    public static String query = "Санкт-Петербург";
    private String address;

    public void checkInfoBlock(boolean infoBlockIsDisplayed) {
        assertTrue(infoBlockIsDisplayed);
    }

    public void checkAddress(String expectedAddress, String actualAddress) {
        this.address = actualAddress;
        checkElementText(expectedAddress, actualAddress);
    }

    public void checkUrl(String expectedUrl, String actualUrl) {
        checkElementText(expectedUrl, actualUrl);
    }

    public void checkResultAddress(String actualAddress) {
        checkElementText(address, actualAddress);
    }
}
