package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.pages.SearchFlightsPage;
import org.ot5usk.steps.DefaultMethods;
import org.ot5usk.steps.tasks.BaseFiltersWorkerImpl;
import java.time.LocalDate;
import java.util.List;

public class SearchFlightsCaseImpl extends DefaultMethods implements SearchFlightsCase {

    public SearchFlightsPage sfPage;
    public BaseFiltersWorkerImpl baseFiltersWorker;
    public WebDriver webDriver;

    public SearchFlightsCaseImpl(WebDriver webDriver, SearchFlightsPage sfPage) {
        super(webDriver, sfPage);
        baseFiltersWorker = new BaseFiltersWorkerImpl(webDriver, sfPage);
        this.sfPage = sfPage;
        this.webDriver = webDriver;
    }

    @Override
    public void clickFiltersBtn() {
        baseFiltersWorker.clickBaseFiltersBtn();
    }

    @Override
    public void selectFilters() {
        baseFiltersWorker.selectBaseFilters();
    }

    @Override
    public void fillFrom(String from) {
        foundHolder(sfPage.from, from);
    }

    @Override
    public void fillTo(String to) {
        foundHolder(sfPage.to, to);
    }

    @Override
    public void fillDate() {
        String desiredDate = String.valueOf(LocalDate.now().plusDays(2).getDayOfMonth());
        sfPage.date.click();
        List<WebElement> tableDates = webElementFindElements(sfPage.dateTable, By.cssSelector(sfPage.searchDateSelector));
        for (WebElement tableDate : tableDates) {
            if (tableDate.getText().equals(desiredDate)) {
                tableDate.click();
                break;
            }
        }
    }

    @Override
    public List<WebElement> getSelectBtns() {
        sfPage.passengers.click();
        return webDriverFindElements(webDriver, By.xpath(sfPage.selectPassengersBtnXpath));
    }

    @Override
    public WebElement getSearchBtn() {
        return sfPage.searchTicketsBtn;
    }
}
