package org.ot5usk.steps.scripts.wb_scripts;

import org.openqa.selenium.WebDriver;
import org.ot5usk.pages.wb_pages.WbChangeCityPage;
import org.ot5usk.steps.tasks.cases.ChangeCityCaseImpl;
import static org.ot5usk.steps.assertions.wb_assertions.WbChangeCityCaseAssertions.query;

public class WbChangeCityScript extends ChangeCityCaseImpl {

    public WebDriver webDriver;
    public WbChangeCityPage wbChangeCityPage;
    public String expectedFirstAddress;
    public String actualFirstAddress;
    public boolean infoBlockIsDisplayed;
    public String currentUrl;

    public WbChangeCityScript(WebDriver webDriver, WbChangeCityPage wbChangeCityPage) {
        super(webDriver, wbChangeCityPage);
        this.webDriver = webDriver;
        this.wbChangeCityPage = wbChangeCityPage;
    }

    public void execute() {
        openSite();
        untilVisibilityOf(wbChangeCityPage.mainPage);
        clickOnTheChangeCityBtn();
        enterQueryInChangeCitySearchBar(query);
        rememberFirstAddress();
        selectFirstAddress();
        rememberInfoBlockData();
        clickSelectBtn();
        rememberCurrentUrl();
    }

    public void rememberFirstAddress() {
        expectedFirstAddress = wbChangeCityPage.firstAddress.getText();
    }

    public void rememberInfoBlockData() {
        infoBlockIsDisplayed = wbChangeCityPage.infoBlock.isDisplayed();
        actualFirstAddress = wbChangeCityPage.infoBlockAddress.getText();
    }

    public void rememberCurrentUrl() {
        currentUrl = webDriver.getCurrentUrl();
    }
}
