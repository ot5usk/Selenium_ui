package org.ot5usk.pages.abstract_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.abstract_pages.methods.FlightsMethods;

import java.time.LocalDate;
import java.util.List;

public abstract class FlightsPage extends Page implements FlightsMethods {

    public WebElement from;
    public WebElement to;
    public WebElement date;
    public WebElement dateTable;
    public WebElement nextTableBtn;
    public String searchDateSelector;
    public WebElement passengers;
    public String selectPassengersBtnXpath;
    public WebElement searchTicketsBtn;
    public WebElement searchResult;

    public FlightsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    @Override
    public void fillFrom(String from) {
        foundHolder(this.from, from);
    }

    @Override
    public void fillTo(String to) {
        foundHolder(this.to, to);
    }

    @Override
    public void fillDate() {
        String desiredDate = String.valueOf(LocalDate.now().plusDays(2).getDayOfMonth());
        clickOnTheElement(date);
        List<WebElement> tableDates = webElementFindElements(dateTable, By.cssSelector(searchDateSelector));
        for (WebElement tableDate : tableDates) {
            if (tableDate.getText().equals(desiredDate)) {
                tableDate.click();
                break;
            }
        }
    }

    @Override
    public void fillPassengers() {
        clickOnTheElement(passengers);
    }

    @Override
    public void clickSearchBtn() {
        clickOnTheElement(searchTicketsBtn);
        waitLoadElement(searchResult);
    }
}
