package com.shantonav.translation.service;

import com.shantonav.translation.util.ApplicationConstants;
import com.shantonav.translation.util.TranslationUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertyFileWriter {

    public  void writePropertyTo (final Properties newProperties , final Locale locale) throws IOException {

        String propertiesText = TranslationUtil.convertToPropertiesText(newProperties);

        String newPropertyFileName =    ApplicationConstants.BASE_PATH_OF_NEW_PROPERTY +
                                        ApplicationConstants.BASE_PROPERTY_PREFIX +
                                        locale +
                                        ApplicationConstants.BASE_PROPERTY_PREFIX;


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newPropertyFileName));

        bufferedWriter.write(propertiesText);
        bufferedWriter.close();
    }
}
