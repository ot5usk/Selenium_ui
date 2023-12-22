package org.ot5usk.pages.wb_pages.wb_pages_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.CatalogPageElements;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbFilters;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbDefaultElements;

import java.util.List;

public class WbCatalogPageElements extends CatalogPageElements {

    public WbDefaultElements wbDefaultElements;
    public WbFilters wbFilters;

    @FindBy(xpath = "//*[contains(@class, 'catalog-page')]")
    public WebElement catalogPage;

    @FindBy(xpath = "//ul[contains(@class, 'breadcrumbs__list')]")
    public WebElement pathFiltersList;

    @FindBy(xpath = "//h1[contains(@class, 'catalog-title')]")
    public WebElement catalogTitleIfUsedPathFilters;

    @FindBy(xpath = "//*[contains(@class, 'searching-results__title')]")
    public WebElement catalogTitleIfUsedSearchBar;

    @FindBy(xpath = "//span[@class='goods-count']")
    public WebElement productsCounter;

    @FindBy(xpath = "//div[@class='product-card__wrapper']")
    public WebElement firstProduct;

    @FindBy(xpath = "//a[contains(@data-link, '/lk/basket')]")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//span[@class='navbar-pc__notify']")
    public WebElement cartCounter;

    @FindBy(xpath = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']")
    public WebElement toCartBtn;

    @FindBy(xpath = "//article[@data-nm-id][1]//span[@class='product-card__name']")
    public WebElement productName;

    @FindBy(xpath = "//article[@data-nm-id][1]//span[@class='product-card__brand']")
    public WebElement productBrand;

    @FindBy(xpath = "//ins[@class='price__lower-price']")
    public WebElement newProductPrice;

    @FindBy(xpath = "//del")
    public WebElement oldProductPrice;

    public WbCatalogPageElements(WebDriver webDriver) {
        super(webDriver, webDriver.getCurrentUrl());
        wbDefaultElements = new WbDefaultElements(webDriver, this);
        wbFilters = new WbFilters(webDriver, this);
        PageFactory.initElements(webDriver, this);
        super.defaultElements = wbDefaultElements;
        super.filters = wbFilters;
        super.catalogPage = catalogPage;
        super.pathFiltersList = pathFiltersList;
        super.catalogTitleIfUsedPathFilters = catalogTitleIfUsedPathFilters;
        super.catalogTitleIfUsedSearchBar = catalogTitleIfUsedSearchBar;
        super.productsCounter = productsCounter;
        super.firstProduct = firstProduct;
        super.addToCartBtn = addToCartBtn;
        super.cartCounter = cartCounter;
        super.toCartBtn = toCartBtn;
        super.productName = productName;
        super.productBrand = productBrand;
        super.newProductPrice = newProductPrice;
        super.oldProductPrice = oldProductPrice;
    }

    public WbCatalogPageElements(WebDriver webDriver, List<WebElement> bottomFilters, List<WebElement> inputBottomFilters) {
        this(webDriver);
        wbFilters = new WbFilters(webDriver, this, bottomFilters, inputBottomFilters);
    }
}
