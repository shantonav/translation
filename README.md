# translation
translating property files using google api


This project uses en_UK as the base locale and takes a bunch of properties files in different locales. 
Checkes which properties are missing against the base locale and uses Google cloud translate API to translate the 
property values and creates new properties with existing and missing translated properties in each of them.

The output of the new properties file could be found under : src/main/resources/newProperties

This project uses Google cloud translate API . Reference :  https://cloud.google.com/translate/docs/quickstart-client-libraries 
