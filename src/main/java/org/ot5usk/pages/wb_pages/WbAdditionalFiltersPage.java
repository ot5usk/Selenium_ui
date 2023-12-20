package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.AdditionalFiltersPage;
import java.util.List;

public class WbAdditionalFiltersPage extends AdditionalFiltersPage {

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    @FindBy(xpath = "//button[contains(@aria-label, 'Навигация по сайту')]")
    public WebElement filtersBtn;

    @FindBy(xpath = "//ul[@class='menu-burger__main-list']//a[text()='Электроника']")
    public WebElement electronics;

    @FindBy(xpath = "//div[@data-menu-id='4830']//span[text()='Ноутбуки и компьютеры']")
    public WebElement laptopsNdComputers;

    @FindBy(xpath = "//div[@data-menu-id='4830']//a[text()='Ноутбуки']")
    public WebElement laptops;

    @FindBy(xpath = "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']")
    public WebElement additionalFiltersBtn;

    @FindBy(xpath = "//input[@name='startN']")
    public WebElement priceFrom;

    @FindBy(xpath = "//input[@name='endN']")
    public WebElement priceTo;

    @FindBy(xpath = "//span[contains(text(), 'до 3 дней')]")
    public WebElement upToThreeDays;

    @FindBy(xpath = "//span[contains(text(), 'Apple')]")
    public WebElement appleBrand;

    @FindBy(xpath = "//span[contains(text(), '13.6')]") //изначально хотели: "13.3", либо мне надо ловить сам фильтр по-другому
    public WebElement screenDiagonal;

    @FindBy(xpath = "//button[@class='filters-desktop__btn-main btn-main']")
    public WebElement showBtn;

    @FindBy(xpath = "//h1[@class='catalog-title']")
    public WebElement titleOpenedPage;

    @FindBy(xpath = "//p[@class='filters-desktop__count-goods']")
    public WebElement foundProductsBefore;

    @FindBy(xpath = "//span[@class='goods-count']")
    public WebElement foundProductsAfter;

    @FindBy(xpath = "//*[@id=\"catalog\"]/div[2]/span/span[1]")
    public WebElement numberOfProductsCounter;

    @FindBy(xpath = "//span[contains(text(), 'до 3 дней')]")
    public WebElement daysChoice;

    @FindBy(xpath = "//span[contains(text(), 'Apple')]")
    public WebElement brandChoice;

    @FindBy(xpath = "//span[contains(text(), 'от 100 000 до 149 000')]")
    public WebElement priceChoice;

    @FindBy(xpath = "//span[contains(text(), '13.6')]")
    public WebElement screenDiagonalChoice;

    @FindBy(xpath = "//button[contains(text(), 'Сбросить все')]")
    public WebElement resetBtn;

    public WbAdditionalFiltersPage(WebDriver webDriver) {
        super("https://www.wildberries.ru/");
        PageFactory.initElements(webDriver, this);

        super.baseFiltersBtn = filtersBtn;
        super.baseFilters = List.of(electronics, laptopsNdComputers, laptops);
        super.additionalFiltersBtn = additionalFiltersBtn;
        super.additionalFilters = List.of(priceFrom, priceTo, upToThreeDays, appleBrand, screenDiagonal);
        super.executeAdditionalFiltersBtn = showBtn;
    }
}
