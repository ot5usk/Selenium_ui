package org.ot5usk.pages.abstract_pages.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface DefaultMethods {

    void open();

    void clickOnTheElement(WebElement webElement);

    void enterTextInElement(WebElement webElement, CharSequence... searchQuery);

    void moveToElement(WebElement webElement);

    WebElement findElement(By searchStrategy);

    List<WebElement> webDriverFindElements(WebDriver webDriver, By searchStrategy);

    List<WebElement> webElementFindElements(WebElement webElement, By searchStrategy);

    void foundHolder(WebElement webElement, String query);

    void untilVisibilityOf(WebElement webElement);

    void untilInvisibilityOf(WebElement webElement);

    void untilToBeClickable(WebElement webElement);

    void untilTextToBePresentInElement(WebElement webElement, String text);

    void waitLoadElement(WebElement webElement);
}
