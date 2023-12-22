package org.ot5usk.steps.search_data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchLaptops {

    @FindBy(xpath = "//ul[@class='menu-burger__main-list']//a[text()='Электроника']")
    public WebElement electronics;

    @FindBy(xpath = "//div[@data-menu-id='4830']//span[text()='Ноутбуки и компьютеры']")
    public WebElement laptopsNdComputers;

    @FindBy(xpath = "//div[@data-menu-id='4830']//a[text()='Ноутбуки']")
    public WebElement laptops;

    @FindBy(xpath = "//input[@name='startN']")
    public WebElement priceFrom;

    @FindBy(xpath = "//input[@name='endN']")
    public WebElement priceTo;

    @FindBy(xpath = "//span[contains(text(), 'до 3 дней')]")
    public WebElement upToThreeDays;

    @FindBy(xpath = "//span[contains(text(), 'Apple')]") // ?apple
    public WebElement appleBrand;

    @FindBy(xpath = "//span[contains(text(), '13.6')]")
    public WebElement screenDiagonal;

    public SearchLaptops(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getSearchPathFilters() {
        return List.of(electronics, laptopsNdComputers, laptops);
    }

    public List<WebElement> getBottomInputFilters() {
        return List.of(priceFrom, priceTo);
    }

    public List<WebElement> getBottomFilters() {
        return List.of(upToThreeDays, appleBrand, screenDiagonal);
    }
}
