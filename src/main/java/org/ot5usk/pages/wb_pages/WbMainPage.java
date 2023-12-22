package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.MainPage;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbDefaultElements;

import java.util.List;

public class WbMainPage extends MainPage {

    public final static String PAGE_URL = "https://www.wildberries.ru/";

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    public WbDefaultElements wbDefaultElements;


    public WbMainPage(WebDriver webDriver) {
        super(webDriver, PAGE_URL);
        PageFactory.initElements(webDriver, this);
        untilVisibilityOf(mainPage);
        wbDefaultElements = new WbDefaultElements(webDriver, this);
        super.defaultElements = wbDefaultElements;
    }

    public WbMainPage(List<WebElement> pathFilters, WebDriver webDriver) {
        super(webDriver, PAGE_URL);
        PageFactory.initElements(webDriver, this);
        untilVisibilityOf(mainPage);
        wbDefaultElements = new WbDefaultElements(webDriver, this, pathFilters);
        super.defaultElements = wbDefaultElements;
    }
}