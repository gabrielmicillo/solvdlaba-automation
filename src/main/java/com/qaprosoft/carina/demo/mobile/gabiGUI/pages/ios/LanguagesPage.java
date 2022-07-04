package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.GoogleTranslatePageBase;
import com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common.LanguagesPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LanguagesPageBase.class)
public class LanguagesPage extends LanguagesPageBase {

    public LanguagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleTranslatePageBase chooseFrench() {
        System.out.println("Not implemented on IOS.");
        return null;
    }

    @Override
    public GoogleTranslatePageBase chooseGreek() {
        System.out.println("Not implemented on IOS.");
        return null;
    }
}
