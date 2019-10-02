package com.shantonav.translation.service;



import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

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

        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        try {
            Translation translation =
                    translate.translate(
                            this.text,
                            Translate.TranslateOption.sourceLanguage(this.sourceLocale.getLanguage()),
                            Translate.TranslateOption.targetLanguage(this.targetLocale.getLanguage()),
                            Translate.TranslateOption.format("text"));
            return translation.getTranslatedText();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Google API ERROR :"+ex.getLocalizedMessage()+" for text="+text+" source lang= "
                    +this.sourceLocale.getLanguage()+" target lang="+this.targetLocale.getLanguage());
        }

        return "TRANSLATION_ERROR";

    }
}
