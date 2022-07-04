package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.GoogleTranslatePageBase;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.LanguagesPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LanguagesPageBase.class)
public class LanguagesPage extends LanguagesPageBase {

    @FindBy(xpath = "//*[@text='French']")
    private ExtendedWebElement frenchButton;

    @FindBy(xpath = "//*[@text='Greek']")
    private ExtendedWebElement greekButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Search']")
    private ExtendedWebElement searchButton;

    public LanguagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchButton.isElementPresent(5);
    }

    public GoogleTranslatePageBase chooseFrench() {
        swipe(frenchButton, 10);
        frenchButton.click();
        GoogleTranslatePageBase googleTranslatePage = initPage(getDriver(), GoogleTranslatePageBase.class);
        return googleTranslatePage;
    }

    public GoogleTranslatePageBase chooseGreek() {
        swipe(greekButton, 10);
        greekButton.click();
        GoogleTranslatePageBase googleTranslatePage = initPage(getDriver(), GoogleTranslatePageBase.class);
        return googleTranslatePage;
    }
}
