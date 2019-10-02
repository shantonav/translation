package com.shantonav.translation.util;

import java.util.Enumeration;
import java.util.Properties;

public class TranslationUtil {

    public static String convertToPropertiesText(final Properties properties){
        Enumeration<Object> propertyKeys = properties.keys();
        StringBuilder sb = new StringBuilder();
        while ( propertyKeys.hasMoreElements() ){
            String propertyKey = (String)propertyKeys.nextElement();
            sb.append(propertyKey)
                    .append(ApplicationConstants.PROPERTY_SEPARATOR)
                    .append(properties.getProperty(propertyKey))
                    .append("\n");
        }
        return sb.toString();
    }
}
