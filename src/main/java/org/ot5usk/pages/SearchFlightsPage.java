package org.ot5usk.pages;

import org.openqa.selenium.WebElement;

public abstract class SearchFlightsPage extends BaseFiltersPage {

    public WebElement from;
    public WebElement to;
    public WebElement date;
    public WebElement dateTable;
    public WebElement nextTableBtn;
    public String searchDateSelector;
    public WebElement passengers;
    public String selectPassengersBtnXpath;
    public WebElement searchTicketsBtn;

    public SearchFlightsPage(String url) {
        super(url);
    }
}
