package com.shantonav.translation.service;

import com.shantonav.translation.reader.file.ReadBaseLocalePropertyFIle;
import com.shantonav.translation.util.ApplicationLocale;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertyWithLocaleServiceImpl implements PropertyWithLocaleService {
    public void createNewPropertiesFrom(Locale baseLocale) {

        TranslationService translationService = new TranslationServiceImpl(baseLocale);
        Properties baseProperties = null;
        try {
            baseProperties = new ReadBaseLocalePropertyFIle().readPropertiesFrom(baseLocale);
        } catch (IOException e) {
            throw new IllegalStateException("Base property not found or could not be read properly");
        }

        for (ApplicationLocale aLocale : ApplicationLocale.values()){
            if (!baseLocale.equals(aLocale)) {
                Locale targetLocale = new Locale(aLocale.getLanguage(), aLocale.getCountry());
                Properties newTranslated = translationService.getTranslatedPropertiesFor(baseProperties, targetLocale);
                try {
                    new PropertyFileWriter().writePropertyTo(newTranslated, targetLocale);
                } catch (IOException e) {
                    throw new IllegalStateException("Target property could not be written");
                }
            }
        }
    }
}
