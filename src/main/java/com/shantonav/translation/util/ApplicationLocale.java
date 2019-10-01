package com.shantonav.translation.util;

public enum ApplicationLocale {
    PT_PT("pt_PT"),
    EN_UK("en_UK"),
    NB_NO("nb_NO"),
    NL_NL("nl_NL"),
    FR_FR("fr_FR"),
    DE_DE("de_DE"),
    BG_BG("bg_BG"),
    HR_HR("hr_HR"),
    CS_CZ("cs_CZ"),
    DA_DK("da_DK"),
    FI_FI("fi_FI"),
    EL_GR("el_GR"),
    HU_HU("hu_HU"),
    IT_IT("it_IT"),
    PL_PL("pl_PL"),
    RO_RO("ro_RO"),
    SK_SK("sk_SK"),
    SL_SI("sl_SI"),
    ES_ES("es_ES"),
    SV_SE("sv_SE");

    private String interName ;


    private String language;
    private String country;

    ApplicationLocale(final String interName){
        this.interName = interName;
        String[] localTokens = interName.split("_");
        this.language = localTokens[0];
        this.country = localTokens[1];
    }

    public String getInterName(){
        return this.interName;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}
