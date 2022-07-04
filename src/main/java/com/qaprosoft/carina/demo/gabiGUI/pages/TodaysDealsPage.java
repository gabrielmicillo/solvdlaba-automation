package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TodaysDealsPage extends AbstractPage {

    @FindBy(xpath = "//a[starts-with(@href, '/-/es/outlet/?')]")
    private ExtendedWebElement outletButton;

    public TodaysDealsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(outletButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public OutletPage clickOutletButton() {
        outletButton.assertElementWithTextPresent("Outlet", 5);
        outletButton.click();
        return new OutletPage(driver);
    }
}
