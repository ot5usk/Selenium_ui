package org.ot5usk.pages.wb_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ot5usk.pages.SearchFlightsPage;
import java.util.List;

public class WbSearchFlightsPage extends SearchFlightsPage {

    @FindBy(xpath = "//div[contains(@class, 'main-page')]")
    public WebElement mainPage;

    @FindBy(xpath = "//button[contains(@aria-label, 'Навигация по сайту')]")
    public WebElement filtersBtn;

    @FindBy(xpath = "//li[@data-menu-id='61037']//a[text()='Путешествия']")
    public WebElement travels;

    @FindBy(xpath = "//div[@data-menu-id='61037']//a[text()='Авиабилеты']")
    public WebElement flights;

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

    @FindBy(xpath = "//div[@class='ant-dropdown-trigger _1701943856481__selector-form-module__passengersField--13fQH']")
    public WebElement passengers;

    public String selectPassengersBtnXpath = "//button[@type='button']"; //18

    @FindBy(xpath = "//button[text()='Найти билеты']")
    public WebElement searchTicketsBtn;

    public WbSearchFlightsPage(WebDriver webDriver) {
        super("https://www.wildberries.ru/");
        PageFactory.initElements(webDriver, this);
        super.baseFilters = List.of(travels, flights);
        super.baseFiltersBtn = filtersBtn;
        super.from = from;
        super.to = to;
        super.date = date;
        super.dateTable = dateTable;
        super.nextTableBtn = nextTableBtn;
        super.searchDateSelector = searchDateSelector;
        super.passengers = passengers;
        super.selectPassengersBtnXpath = selectPassengersBtnXpath;
        super.searchTicketsBtn = searchTicketsBtn;
    }
}
