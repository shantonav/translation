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

        String targetPropertyFileName = ApplicationConstants.PATH_OF_NEW_PROPERTY +
                                        ApplicationConstants.PROPERTY_PREFIX +
                                        locale +
                                        ApplicationConstants.PROPERTY_SUFFIX;


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetPropertyFileName));

        bufferedWriter.newLine();
        bufferedWriter.write(propertiesText);
        bufferedWriter.close();
    }
}
