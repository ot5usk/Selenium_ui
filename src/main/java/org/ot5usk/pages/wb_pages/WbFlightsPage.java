package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.abstract_pages.FlightsPage;

public class WbFlightsPage extends FlightsPage {

    public final static String PAGE_URL = "https://vmeste.wildberries.ru/avia";

    @FindBy(xpath = "//span/input[@id='rc_select_0']")
    public WebElement from;
    @FindBy(xpath = "//span/input[@id='rc_select_1']")
    public WebElement to;

    @FindBy(xpath = "//div[text()='Туда']")
    public WebElement date;

    @FindBy(xpath = "//div[@class='ant-picker-body']//table[@class='ant-picker-content']")
    public WebElement dateTable;

    @FindBy(xpath = "//button[@class='ant-picker-header-next-btn']")
    public WebElement nextTableBtn;

    public String searchDateSelector = "td[title]";

    @FindBy(xpath = "//div[contains(text(), 'пассажир')]")
    public WebElement passengers;

    public String selectPassengersBtnXpath = "//button[@type='button']"; //18

    @FindBy(xpath = "//button[text()='Найти билеты']")
    public WebElement searchTicketsBtn;

    @FindBy(xpath = "//div[@data-module='vmeste-avia-v2']")
    public WebElement searchResult;

    public WbFlightsPage(WebDriver webDriver) {
        super(webDriver, PAGE_URL);
        PageFactory.initElements(webDriver, this);
        super.from = from;
        super.to = to;
        super.date = date;
        super.dateTable = dateTable;
        super.nextTableBtn = nextTableBtn;
        super.searchDateSelector = searchDateSelector;
        super.passengers = passengers;
        super.selectPassengersBtnXpath = selectPassengersBtnXpath;
        super.searchTicketsBtn = searchTicketsBtn;
        super.searchResult = searchResult;
    }

    @Override
    public void fillPassengers() {
        super.fillPassengers();
        clickOnTheElement(webDriverFindElements(webDriver, By.xpath(selectPassengersBtnXpath)).get(18));
    }
}
