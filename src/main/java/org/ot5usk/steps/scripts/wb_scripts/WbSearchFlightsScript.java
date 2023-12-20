package org.ot5usk.steps.scripts.wb_scripts;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbSearchFlightsPage;
import org.ot5usk.steps.tasks.cases.SearchFlightsCaseImpl;

public class WbSearchFlightsScript extends SearchFlightsCaseImpl {

    public WebDriver webDriver;
    public WbSearchFlightsPage wbSfPage;
    public String actualUrl;

    public WbSearchFlightsScript(WebDriver webDriver, WbSearchFlightsPage wbSfPage) {
        super(webDriver, wbSfPage);
        this.webDriver = webDriver;
        this.wbSfPage = wbSfPage;
    }

    public void execute() {
        openSite();
        untilVisibilityOf(wbSfPage.mainPage);
        clickFiltersBtn();
        selectFilters();
        rememberUrl();
        fillFrom("Домодедово");
        fillTo("Пулково");
        fillDate();
        getSelectBtns().get(18).click();
        getSearchBtn().click();
    }

    public void rememberUrl() {
        actualUrl = webDriver.getCurrentUrl();
    }
}
