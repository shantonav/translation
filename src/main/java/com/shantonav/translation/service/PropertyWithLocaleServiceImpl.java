package com.shantonav.translation.service;

import com.shantonav.translation.reader.file.ReadBaseLocalePropertyFIle;
import com.shantonav.translation.util.ApplicationConstants;
import com.shantonav.translation.util.ApplicationLocale;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertyWithLocaleServiceImpl implements PropertyWithLocaleService {
    public void createNewPropertiesFrom(Locale baseLocale) {

        TranslationService translationService = new TranslationServiceImpl(baseLocale);

        try {

            File newPropertyDir = new File (ApplicationConstants.PATH_OF_NEW_PROPERTY);
            if (!newPropertyDir.exists()) {
                if (newPropertyDir.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not clean dir:" + ApplicationConstants.PATH_OF_NEW_PROPERTY);
        }
        Properties baseProperties = null;
        try {
            baseProperties = new ReadBaseLocalePropertyFIle().readPropertiesFrom(baseLocale);
        } catch (IOException e) {
            throw new IllegalStateException("Base property not found or could not be read properly");
        }

        if ( baseProperties != null) {
            for (ApplicationLocale aLocale : ApplicationLocale.values()) {
                if (! baseLocale.getLanguage().equals(aLocale.getLanguage())) {
                    Locale targetLocale = new Locale(aLocale.getLanguage(), aLocale.getCountry());
                    Properties newTranslated = translationService.getTranslatedPropertiesFor(baseProperties, targetLocale);
                    try {
                        new PropertyFileWriter().writePropertyTo(newTranslated, targetLocale);
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new IllegalStateException("Target property could not be written");
                    }
                }
            }
        }
    }
}
