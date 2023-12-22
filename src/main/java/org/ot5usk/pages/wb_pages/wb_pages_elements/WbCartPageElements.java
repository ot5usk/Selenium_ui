package org.ot5usk.pages.wb_pages.wb_pages_elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.abstract_pages_elements.CartPageElements;
import org.ot5usk.pages.wb_pages.wb_pages_elements.wb_default_pages_elements.WbDefaultElements;

public class WbCartPageElements extends CartPageElements {

    public WbDefaultElements wbDefaultElements;

    @FindBy(xpath = " //a[@class='good-info__title j-product-popup']")
    public WebElement productName;

    @FindBy(xpath = "//div[@class='list-item__price-new']")
    public WebElement newProductPrice;

    @FindBy(xpath = "//div[@class='list-item__price-old']")
    public WebElement oldProductPrice;

    @FindBy(xpath = "//div[@class='list-item__price-new']")
    public WebElement newTotalProductPrice;

    @FindBy(xpath = "//div[@class='list-item__price-old']")
    public WebElement oldTotalProductPrice;

    @FindBy(xpath = "//div[@class='basket-order__b-btn b-btn']")
    public WebElement orderBtn;

    public WbCartPageElements(WebDriver webDriver) {
        super(webDriver, webDriver.getCurrentUrl());
        wbDefaultElements = new WbDefaultElements(webDriver, this);
        PageFactory.initElements(webDriver, this);
        super.defaultElements = wbDefaultElements;
        super.productName = productName;
        super.newProductPrice = newProductPrice;
        super.oldProductPrice = oldProductPrice;
        super.newTotalProductPrice = newTotalProductPrice;
        super.oldTotalProductPrice = oldTotalProductPrice;
        super.orderBtn = orderBtn;
    }
}
