package org.ot5usk.steps.tasks.cases;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.ChangeCityPage;
import org.ot5usk.steps.DefaultMethods;

public class ChangeCityCaseImpl extends DefaultMethods implements ChangeCityCase {

    private final ChangeCityPage changeCityPage;

    public ChangeCityCaseImpl(WebDriver webDriver, ChangeCityPage changeCityPage) {
        super(webDriver, changeCityPage);
        this.changeCityPage = changeCityPage;
    }

    @Override
    public void clickOnTheChangeCityBtn() {
        clickOnTheElement(changeCityPage.changeCityMenu);
    }

    @Override
    public void enterQueryInChangeCitySearchBar(String searchQuery) {
        enterTextInElement(changeCityPage.changeCitySearchBar, searchQuery);
        sendEnterKey(changeCityPage.changeCitySearchBar);
    }

    @Override
    public void selectFirstAddress() {
        clickOnTheElement(changeCityPage.firstAddress);
    }

    @Override
    public void clickSelectBtn() {
        clickOnTheElement(changeCityPage.selectBtn);
    }
}
