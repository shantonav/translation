package com.shantonav.translation.service;

import com.shantonav.translation.reader.file.ReadBaseLocalePropertyFIle;
import com.shantonav.translation.util.ApplicationConstants;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

public class TranslationServiceImpl implements  TranslationService {

    private Locale baseLocale ;

    public  TranslationServiceImpl(final  Locale baseLocale){
        this.baseLocale = baseLocale;
    }

    public Properties getTranslatedPropertiesFor(final Properties baseProperties, final Locale targetLocale) {
        Properties transLatedProperties = new Properties();

        Properties targetProperties = null;
        try {
            targetProperties = new ReadBaseLocalePropertyFIle().readPropertiesFrom(targetLocale);
        } catch (IOException e) {
            throw new IllegalStateException("Base property not found or could not be read properly for "+targetLocale);
        }

        if ( targetProperties != null) {
            Enumeration<Object> propertyKeys = baseProperties.keys();
            StringBuilder stringBuilder = new StringBuilder();
            boolean isThereSomethingToTranslate = false;

            while (propertyKeys.hasMoreElements()) {
                String propertyKey = (String) propertyKeys.nextElement();

                if (!targetProperties.containsKey(propertyKey)) {

                    transLatedProperties.put(propertyKey, new GoogleTranslateService((String) baseProperties.get(propertyKey), baseLocale, targetLocale).translate());
                    if (!isThereSomethingToTranslate) {
                        stringBuilder.append("Properties for ==================:" + targetLocale + "\n");
                        isThereSomethingToTranslate = true;
                    }
                    stringBuilder.append(propertyKey)
                            .append(ApplicationConstants.PROPERTY_SEPARATOR)
                            .append(transLatedProperties.getProperty(propertyKey))
                            .append("\n");
                }else{
                    transLatedProperties.put(propertyKey, targetProperties.getProperty(propertyKey));
                }
            }
            if (isThereSomethingToTranslate) {
                stringBuilder.append("End of properties for ==================:" + targetLocale + "\n");
            }
            System.out.println(stringBuilder.toString());
        }


        return transLatedProperties;
    }
}
