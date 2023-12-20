package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.SearchBarPage;
import org.ot5usk.steps.DefaultMethods;

public class SearchBarCaseImpl extends DefaultMethods implements SearchBarCase {

    private final SearchBarPage searchBarPage;

    public SearchBarCaseImpl(WebDriver webDriver, SearchBarPage searchBarPage) {
        super(webDriver, searchBarPage);
        this.searchBarPage = searchBarPage;
    }

    @Override
    public void clickOnTheSearchBar() {
        clickOnTheElement(searchBarPage.searchBar);
    }

    @Override
    public void enterQueryInSearchBar(String searchQuery) {
        enterTextInElement(searchBarPage.searchBar, searchQuery);
    }

    @Override
    public void sendEnterKeyInSearchBar() {
        sendEnterKey(searchBarPage.searchBar);
    }

    @Override
    public void clickTheCross() {
        clickTheCross(searchBarPage.cross);
    }
}
