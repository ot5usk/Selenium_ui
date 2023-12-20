package org.ot5usk.steps.scripts.wb_scripts;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbSearchBarPage;
import org.ot5usk.steps.assertions.wb_assertions.WbSearchBarCaseAssertions;
import org.ot5usk.steps.tasks.cases.SearchBarCaseImpl;

public class WbSearchBarScript extends SearchBarCaseImpl {

    public WebDriver webDriver;
    public WbSearchBarPage wbSearchBarPage;

    public WbSearchBarScript(WebDriver webDriver, WbSearchBarPage wbSearchBarPage) {
        super(webDriver, wbSearchBarPage);
        this.webDriver = webDriver;
        this.wbSearchBarPage = wbSearchBarPage;
    }

    public void execute() {
        openSite();
        untilVisibilityOf(wbSearchBarPage.mainPage);
        clickOnTheSearchBar();
        enterQueryInSearchBar(WbSearchBarCaseAssertions.query);
        sendEnterKeyInSearchBar();
        untilVisibilityOf(wbSearchBarPage.catalogPage);
        clickTheCross();
    }
}
