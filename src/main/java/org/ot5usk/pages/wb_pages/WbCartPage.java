package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.CartPage;
import java.util.List;

public class WbCartPage extends CartPage {

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    @FindBy(xpath = "//button[contains(@aria-label, 'Навигация по сайту')]")
    public WebElement filtersBtn;

    @FindBy(xpath = "//ul[@class='menu-burger__main-list']//a[text()='Бытовая техника']")
    public WebElement householdAppliances;

    @FindBy(xpath = "//div[@data-menu-id='16107']//span[text()='Техника для дома']")
    public WebElement homeAppliances;

    @FindBy(xpath = "//span[text()='Пылесосы и пароочистители']")
    public WebElement vacuumNdSteamCleaners;

    @FindBy(xpath = "//div[@data-menu-id='16107']//a[text()='Пылесосы и пароочистители']")
    public WebElement vacuumNdSteamCleaners2;

    @FindBy(xpath = "//h1[contains(@class, 'catalog-title')]")
    public WebElement filtersResult;

    @FindBy(xpath = "//ul[contains(@class, 'breadcrumbs__list')]")
    public WebElement pathFilters;

    @FindBy(xpath = "//div[@class='product-card__wrapper']")
    public WebElement firstProduct;

    @FindBy(xpath = "//a[contains(@data-link, '/lk/basket')]")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//span[@class='navbar-pc__notify']")
    public WebElement cartCounter;

    @FindBy(xpath = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']")
    public WebElement toCartBtn;

    @FindBy(xpath = "//article[@data-nm-id][1]//span[@class='product-card__name']")
    public WebElement productNameInCatalog;

    @FindBy(xpath = "//article[@data-nm-id][1]//span[@class='product-card__brand']")
    public WebElement productBrandInCatalog;

    @FindBy(xpath = "//ins[@class='price__lower-price']")
    public WebElement newProductPriceInCatalog;

    @FindBy(xpath = "//del")
    public WebElement oldProductPriceInCatalog;

    @FindBy(xpath = " //a[@class='good-info__title j-product-popup']")
    public WebElement productNameInCart;

    @FindBy(xpath = "//div[@class='list-item__price-new']")
    public WebElement newProductPriceInCart;

    @FindBy(xpath = "//div[@class='list-item__price-old']")
    public WebElement oldProductPriceInCart;

    @FindBy(xpath = "//div[@class='list-item__price-new']")
    public WebElement newTotalProductPriceInCart;

    @FindBy(xpath = "//div[@class='list-item__price-old']")
    public WebElement oldTotalProductPriceInCart;

    @FindBy(xpath = "//div[@class='basket-order__b-btn b-btn']")
    public WebElement orderBtn;

    public WbCartPage(WebDriver webDriver) {
        super("https://www.wildberries.ru/");
        PageFactory.initElements(webDriver, this);
        super.baseFiltersBtn = filtersBtn;
        super.baseFilters = List.of(householdAppliances, homeAppliances, vacuumNdSteamCleaners, vacuumNdSteamCleaners2);

        super.filtersResult = filtersResult;
        super.pathFilters = pathFilters;
        super.addToCartBtn = addToCartBtn;
        super.firstProduct = firstProduct;
        super.cartCounter = cartCounter;
        super.toCartBtn = toCartBtn;
    }
}
