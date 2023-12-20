package org.ot5usk.steps.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CaseAssertions {

    public void checkElementText(String expectedElementText, String actualElementText) {
        assertEquals(expectedElementText, actualElementText);
    }
}
