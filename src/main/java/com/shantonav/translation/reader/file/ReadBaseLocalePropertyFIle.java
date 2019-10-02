package com.shantonav.translation.reader.file;

import com.shantonav.translation.util.ApplicationConstants;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class ReadBaseLocalePropertyFIle {


    public Properties readPropertiesFrom (final Locale baseLocale) throws IOException {
        final Properties basePropery = new Properties();
        String propertiesFileName = ApplicationConstants.BASE_PATH_TO_PROPERTIES +
                ApplicationConstants.PROPERTY_PREFIX + baseLocale
                + ApplicationConstants.PROPERTY_SUFFIX;
        File propertyFile = new File(propertiesFileName);

        if ( propertyFile.exists() ){
            InputStream is = new FileInputStream(new File(propertiesFileName));
            if (is == null) {
                System.out.println("Property file could not be read " + propertiesFileName);
            }else{
                basePropery.load(is);
            }

        }else{
            System.out.println("Missing property file !!! " + propertiesFileName);
        }

        return basePropery;
    }
}
