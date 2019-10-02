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
                try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(propertyFile), "UTF-8")) ) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] propertyTokens = line.split(ApplicationConstants.PROPERTY_SEPARATOR);
                        basePropery.put(propertyTokens[0], propertyTokens[1]);
                    }
                }

            }

        }else{
            System.out.println("Missing property file !!! " + propertiesFileName);
        }

        return basePropery;
    }
}
