package com.shantonav.translation.reader.file;

import com.shantonav.translation.util.ApplicationConstants;

import java.io.*;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;

public class ReadBaseLocalePropertyFIle {


    public Properties readPropertiesFrom (final Locale baseLocale) throws IOException {
        final Properties basePropery = new Properties();
        InputStream is = ReadBaseLocalePropertyFIle.class.getResourceAsStream(ApplicationConstants.BASE_PROPERTY_PREFIX + baseLocale
                + ApplicationConstants.BASE_PROPERTY_SUFIX);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        while ( bufferedReader.ready()){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(),"=");

            while ( stringTokenizer.hasMoreTokens()) {
                basePropery.put(stringTokenizer.nextToken(),stringTokenizer.nextToken());
            }
        }

        return basePropery;

    }
}
