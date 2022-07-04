package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WorkWithUsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='portal-tiles']")
    private ExtendedWebElement portalTilesSection;

    @FindBy(xpath = "//div[@id='search-container']//input[@id='search_typeahead']")
    private ExtendedWebElement jobField;

    @FindBy(css = "#search-button")
    private ExtendedWebElement searchButton;

    public WorkWithUsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(portalTilesSection);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public JobResultsPage searchJob(String job) {
        jobField.assertElementPresent(5);
        jobField.click();
        jobField.type(job);
//        jobField.type(R.TESTDATA.get(job));
        searchButton.click();
        return new JobResultsPage(driver);
    }
}
