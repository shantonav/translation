package test.shantonav.translation;

import com.shantonav.translation.service.GoogleTranslateService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestGoogleTextTranslation {

    @Test
    public void testGoogleSingleTextTranslation(){
        GoogleTranslateService googleTranslateService = new GoogleTranslateService("Hello world", Locale.UK, Locale.FRANCE) ;

        Assert.assertTrue("Bonjour le monde!".equalsIgnoreCase(googleTranslateService.translate()));
    }
}
