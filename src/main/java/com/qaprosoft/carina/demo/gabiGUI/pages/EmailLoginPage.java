package com.qaprosoft.carina.demo.gabiGUI.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmailLoginPage extends AbstractPage {

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(css = "#ap_email")
    private ExtendedWebElement emailField;

    public EmailLoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(continueButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void fillWithEmail(){
        emailField.type(R.TESTDATA.get("user_email"));
    }

    public PasswordLoginPage clickContinueButton(){
        continueButton.click();
        return new PasswordLoginPage(driver);
    }

}
