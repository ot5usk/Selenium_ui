package org.ot5usk.steps.assertions.wb_assertions;

import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCartPageElements;
import org.ot5usk.pages.wb_pages.wb_pages_elements.WbCatalogPageElements;
import org.ot5usk.steps.assertions.WbAssertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WbCartAssertions extends WbAssertions {

    public static void checkProductName(WbCatalogPageElements catalogElements, WbCartPageElements cartElements) {
        List<String> productInCatalog = List.of(catalogElements.productName.getText(), catalogElements.productBrand.getText());
        List<String> result = new ArrayList<>();
        for (String s : productInCatalog) {
            List<String> temp = Arrays.stream(s.split(" ")).toList();
            temp = temp.stream().map(e -> e.replaceAll("[^A-Za-zА-Яа-я0-9]", "")).toList();
            temp = temp.stream().filter(e -> !e.isEmpty()).toList();
            result.addAll(temp);
        }
        for (String s : result) {
            assertTrue(cartElements.productName.getText().contains(s));
        }
    }

    public static void checkProductPrice(WbCatalogPageElements catalogElements, WbCartPageElements cartElements) {
        assertDoesNotThrow(() -> cartElements.untilTextToBePresentInElement(cartElements.newProductPrice, catalogElements.newProductPrice.getText()));
        assertDoesNotThrow(() -> cartElements.untilTextToBePresentInElement(cartElements.oldProductPrice, catalogElements.oldProductPrice.getText()));
    }

    public static void checkTotalProductPrice(WbCatalogPageElements catalogElements, WbCartPageElements cartElements) {
        assertDoesNotThrow(() -> cartElements.untilTextToBePresentInElement(cartElements.newTotalProductPrice, catalogElements.newProductPrice.getText()));
        assertDoesNotThrow(() -> cartElements.untilTextToBePresentInElement(cartElements.oldTotalProductPrice, catalogElements.oldProductPrice.getText()));
    }

    public static void checkOrderBtn(WbCartPageElements cartElements) {
        assertDoesNotThrow(() -> cartElements.untilToBeClickable(cartElements.orderBtn));
    }
}
