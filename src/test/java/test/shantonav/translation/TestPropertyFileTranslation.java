package test.shantonav.translation;

import com.shantonav.translation.service.PropertyWithLocaleServiceImpl;
import com.shantonav.translation.util.ApplicationLocale;
import org.junit.Test;

import java.util.Locale;

public class TestPropertyFileTranslation {

    @Test
    public void testPropertyFileTranslationFromEnglishToAllTheSupportedLanguages(){
        new PropertyWithLocaleServiceImpl().createNewPropertiesFrom(new Locale(ApplicationLocale.EN_UK.getLanguage(), ApplicationLocale.EN_UK.getCountry()));
    }
}
