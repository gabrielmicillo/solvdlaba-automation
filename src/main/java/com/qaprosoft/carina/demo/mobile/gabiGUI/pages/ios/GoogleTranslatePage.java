package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.android.LanguagesPage;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.GoogleTranslatePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = GoogleTranslatePageBase.class)
public class GoogleTranslatePage extends GoogleTranslatePageBase {

    public GoogleTranslatePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterTextToTranslate() {
        System.out.println("Not implemented on IOS.");
    }

    @Override
    public String compareTranslation() {
        System.out.println("Not implemented on IOS.");
        return null;
    }

    @Override
    public String getCorrectTranslation(String correctTranslation) {
        System.out.println("Not implemented on IOS.");
        return null;
    }

    @Override
    public LanguagesPage changeLanguageFrom() {
        System.out.println("Not implemented on IOS.");
        return null;
    }

    @Override
    public LanguagesPage changeLanguageTo() {
        System.out.println("Not implemented on IOS.");
        return null;
    }

}
