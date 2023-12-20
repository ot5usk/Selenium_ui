package org.ot5usk.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ot5usk.pages.Page;
import java.time.Duration;
import java.util.List;

public class DefaultMethods {

    private final WebDriver webDriver;
    public WebDriverWait wait;
    public Page page;
    public Actions actions;

    public DefaultMethods(WebDriver webDriver, Page page) {
        this.page = page;
        this.webDriver = webDriver;
        this.actions = new Actions(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
    }

    public void openSite() {
        webDriver.get(page.url);
    }

    public void clickOnTheElement(WebElement webElement) {
        webElement.click();
    }

    public void enterTextInElement(WebElement webElement, CharSequence... searchQuery) {
        untilVisibilityOf(webElement);
        webElement.sendKeys(searchQuery);
    }

    public void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

    public void sendEnterKey(WebElement webElement) {
        untilVisibilityOf(webElement);
        webElement.sendKeys(Keys.ENTER);
    }

    public WebElement findElement(By searchStrategy) {
        return webDriver.findElement(searchStrategy);
    }

    public List<WebElement> webDriverFindElements(WebDriver webDriver, By searchStrategy) {
        return webDriver.findElements(searchStrategy);
    }

    public List<WebElement> webElementFindElements(WebElement webElement, By searchStrategy) {
        return webElement.findElements(searchStrategy);
    }

    public void foundHolder(WebElement webElement, String query) {
        enterTextInElement(webElement, query);
        String holderXpath = "//div[contains(@label, '" + query + "')]";
        WebElement holder = findElement(By.xpath(holderXpath));
        clickOnTheElement(holder);
    }

    public void clickTheCross(WebElement cross) {
        untilVisibilityOf(cross);
        cross.click();
    }

    public void untilVisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void untilInvisibilityOf(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void untilToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void untilTextToBePresentInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public void waitLoadElement(WebElement webElement) {
        try {
            untilInvisibilityOf(webElement);
        } catch(Exception e) {
            untilVisibilityOf(webElement);
        }
    }
}
