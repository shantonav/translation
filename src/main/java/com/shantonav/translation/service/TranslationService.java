package com.shantonav.translation.service;

import java.util.Locale;
import java.util.Properties;

public interface  TranslationService {
    Properties getTranslatedPropertiesFor (final Properties properties, final Locale targetLocale);
}
