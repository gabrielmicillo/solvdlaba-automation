package com.qaprosoft.carina.demo.mobile.gabiGUI.pages.common;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LanguagesPageBase extends AbstractPage implements IMobileUtils {

    public LanguagesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GoogleTranslatePageBase chooseFrench();

    public abstract GoogleTranslatePageBase chooseGreek();

}
