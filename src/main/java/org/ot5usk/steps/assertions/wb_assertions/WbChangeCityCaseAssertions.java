package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.WbChangeCityPage;
import org.ot5usk.steps.assertions.CaseAssertions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WbChangeCityCaseAssertions extends CaseAssertions {

    private final WbChangeCityPage wbChCityPage;
    public static String query = "Санкт-Петербург";
    private String firstAddress;

    public WbChangeCityCaseAssertions(WbChangeCityPage wbChCityPage) {
        this.wbChCityPage = wbChCityPage;
    }

    public void checkInfoBlock(boolean infoBlockIsDisplayed) {
        assertTrue(infoBlockIsDisplayed);
    }

    public void checkFirstAddress(String expectedFirstAddress, String actualFirstAddress) {
        firstAddress = actualFirstAddress;
        checkElementText(expectedFirstAddress, actualFirstAddress);
    }

    public void checkUrl(String currentUrl) {
        checkElementText(wbChCityPage.url, currentUrl);
    }

    public void checkResultAddress() {
        checkElementText(wbChCityPage.resultAddress.getText(), firstAddress);
    }
}
