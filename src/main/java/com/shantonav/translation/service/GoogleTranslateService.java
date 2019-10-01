package com.shantonav.translation.service;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

import java.util.Locale;

public class GoogleTranslateService {
    private String text;
    private Locale sourceLocale;
    private Locale targetLocale;

    public  GoogleTranslateService (final String original, final Locale baseLocale, final Locale targetLocale){
        this.text = original;
        this.sourceLocale = baseLocale;
        this.targetLocale = targetLocale;
    }

    public String translate(){
        Translate.setHttpReferrer("http://www.example.com");
        try {
           return  Translate.execute(this.text, Language.fromString(this.sourceLocale.getLanguage()), Language.fromString(this.targetLocale.getLanguage()) );
        } catch (Exception e) {
            return "COULD_NOT_TRANSLATE";
        }


    }
}
