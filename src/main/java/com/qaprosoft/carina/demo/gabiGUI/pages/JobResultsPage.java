package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class JobResultsPage extends AbstractPage {

    @FindBy(css = ".search-container")
    private ExtendedWebElement sideBar;

    public JobResultsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sideBar);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

}
