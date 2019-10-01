package com.shantonav.translation.service;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

public class TranslationServiceImpl implements  TranslationService {

    private Locale baseLocale ;

    public  TranslationServiceImpl(final  Locale baseLocale){
        this.baseLocale = baseLocale;
    }

    public Properties getTranslatedPropertiesFor(final Properties properties, final Locale targetLocale) {
        Properties transLatedProperties = new Properties();

        Enumeration<Object> propertyKeys = properties.keys();

        while ( propertyKeys.hasMoreElements() ){
            String propertyKey = (String ) propertyKeys.nextElement();

            transLatedProperties.put(propertyKey, new  GoogleTranslateService( (String )properties.get(propertyKey), baseLocale, targetLocale).translate() );
        }


        return transLatedProperties;
    }
}
