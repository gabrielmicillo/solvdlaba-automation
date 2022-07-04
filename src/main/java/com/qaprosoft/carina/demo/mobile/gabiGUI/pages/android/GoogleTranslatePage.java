package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.android;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.GoogleTranslatePageBase;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.LanguagesPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = GoogleTranslatePageBase.class)
public class GoogleTranslatePage extends GoogleTranslatePageBase {

    @FindBy(xpath = "//*[@text='Enter text']")
    private ExtendedWebElement enterTextSpace;

    @FindBy(xpath = "//*[ends-with(@resource-id, 'text_output_field')]")
    private ExtendedWebElement translatedText;

    @FindBy(xpath = "//android.widget.TextView[ends-with(@resource-id, 'product_name')]")
    private ExtendedWebElement translateHeader;

    @FindBy(xpath = "//*[ends-with(@resource-id, 'language_button_a')]")
    private ExtendedWebElement translateFromLanguageButton;

    @FindBy(xpath = "//*[ends-with(@resource-id, 'language_button_b')]")
    private ExtendedWebElement translateToLanguageButton;

    public GoogleTranslatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterTextToTranslate() {
        enterTextSpace.click();
        enterTextSpace.type(R.TESTDATA.get("text_to_translate"));
    }

    @Override
    public String compareTranslation() {
        String translation = translatedText.getText();
        return translation;
    }

    @Override
    public String getCorrectTranslation(String correctTranslation) {
        String translation = R.TESTDATA.get(correctTranslation);
        return translation;
    }

    @Override
    public LanguagesPageBase changeLanguageFrom() {
        translateFromLanguageButton.click();
        LanguagesPageBase languagesPage = initPage(getDriver(), LanguagesPageBase.class);
        return languagesPage;
    }

    @Override
    public LanguagesPageBase changeLanguageTo() {
        translateToLanguageButton.click();
        LanguagesPageBase languagesPage = initPage(getDriver(), LanguagesPageBase.class);
        return languagesPage;
    }

    @Override
    public boolean isPageOpened() {
        return translateHeader.isElementPresent(5);
    }

}
