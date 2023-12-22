package org.ot5usk.steps.assertions.wb_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.WbAssertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WbBottomFiltersAssertions extends WbAssertions {

    public static String expectedPageTitle = "Ноутбуки и ультрабуки";
    public static List<String> expectedFiltersChoice = List.of("до 3 дней", "Apple", "от 100 000 до 149 000", "13.6\"");

    public static void checkOpenedPage(WbCatalogPageElements catalogElements) {
        checkElementText(expectedPageTitle, catalogElements.catalogTitleIfUsedPathFilters.getText());
    }

    public static void checkFilterActivity(String counterBeforeUseBf, WbCatalogPageElements catalogElements) {
        String before = counterBeforeUseBf.replaceAll("[^0-9]", "");
        String after = catalogElements.productsCounter.getText().replaceAll("[^0-9]", "");
        assertTrue(Long.parseLong(after) <= Long.parseLong(before)); // <=, =?
    }

    public static void checkProductsCounter(WebDriver webDriver, WbCatalogPageElements catalogElements) {
        int productsCount = webDriver.findElements(By.xpath("//div[@class='product-card__wrapper']")).size();
        assertEquals(catalogElements.productsCounter.getText().replaceAll("[^0-9]", ""), Integer.toString(productsCount));
    }

    public static void checkDisplayOfFilters(WebDriver webDriver, WbCatalogPageElements catalogElements) {
        List<WebElement> choices = webDriver.findElements(catalogElements.wbFilters.choiceBottomFilters);
        for (int i = 0; i < expectedFiltersChoice.size(); i++) {
            assertEquals(expectedFiltersChoice.get(i).toLowerCase(), choices.get(i).getText().toLowerCase());
        }
    }

    public static void checkVisibilityOfResetBtn(WbCatalogPageElements catalogElements) {
        assertTrue(catalogElements.wbFilters.resetBtn.isDisplayed());
        assertTrue(catalogElements.wbFilters.resetBtn.isEnabled());
    }
}
