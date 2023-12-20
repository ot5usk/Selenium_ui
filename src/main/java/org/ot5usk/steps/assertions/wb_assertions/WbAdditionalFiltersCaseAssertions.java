package org.ot5usk.steps.assertions.wb_assertions;

import org.openqa.selenium.By;
import org.ot5usk.pages.wb_pages.WbAdditionalFiltersPage;
import org.ot5usk.steps.assertions.CaseAssertions;
import org.ot5usk.steps.scripts.wb_scripts.WbAdditionalFiltersScript;
import static org.junit.jupiter.api.Assertions.*;

public class WbAdditionalFiltersCaseAssertions extends CaseAssertions {

    private final WbAdditionalFiltersPage wbAFiltersPage;
    private final WbAdditionalFiltersScript wbAFiltersScript;
    public String expectedPageTitle = "Ноутбуки и ультрабуки";

    public WbAdditionalFiltersCaseAssertions(WbAdditionalFiltersPage wbAFiltersPage, WbAdditionalFiltersScript wbAFiltersScript) {
        this.wbAFiltersPage = wbAFiltersPage;
        this.wbAFiltersScript = wbAFiltersScript;
    }

    public void checkOpenedPage() {
        checkElementText(expectedPageTitle, wbAFiltersPage.titleOpenedPage.getText());
    }

    public void checkFilterActivity() {
        String before = wbAFiltersScript.productsBefore.replaceAll("[^0-9]", "");
        String after = wbAFiltersScript.productsAfter.replaceAll("[^0-9]", "");
        assertNotEquals(before, after);
    }

    public void checkProductCount() {
        int productsCount = wbAFiltersScript.webDriver.findElements(By.xpath("//div[@class='product-card__wrapper']")).size();
        assertEquals(wbAFiltersPage.numberOfProductsCounter.getText(), Integer.toString(productsCount));
    }

    public void checkDisplayOfFilters() {
        assertEquals(wbAFiltersPage.daysChoice.getText(), "до 3 дней");
        assertEquals(wbAFiltersPage.brandChoice.getText(), "Apple");
        assertEquals(wbAFiltersPage.priceChoice.getText(), "от 100 000 до 149 000");
        assertEquals(wbAFiltersPage.screenDiagonalChoice.getText(), "13.6\"");
    }

    public void checkVisibilityOfResetBtn() {
        assertTrue(wbAFiltersPage.resetBtn.isDisplayed());
        assertTrue(wbAFiltersPage.resetBtn.isEnabled());
    }
}
