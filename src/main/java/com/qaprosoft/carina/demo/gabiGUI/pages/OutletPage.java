package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gabiGUI.components.NavigateMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OutletPage extends AbstractPage {

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    private ExtendedWebElement searchInOutletInput;

    @FindBy(id = "nav-belt")
    private NavigateMenu navigateMenu;

    @FindBy(id = "top_2")
    private ExtendedWebElement outletCategories;

    public OutletPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(outletCategories);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public NavigateMenu getNavigateMenu() {
        return navigateMenu;
    }

}
