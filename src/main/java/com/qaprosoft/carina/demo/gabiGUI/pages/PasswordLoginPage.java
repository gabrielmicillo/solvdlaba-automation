package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PasswordLoginPage extends AbstractPage {

    @FindBy(id = "signInSubmit")
    private ExtendedWebElement submitPassButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passwordField;

    public PasswordLoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(submitPassButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void fillWithPassword() {
        passwordField.type(R.TESTDATA.get("password"));
    }

    public HomePage clickSubmitButton() {
        submitPassButton.click();
        return new HomePage(driver);
    }
}
