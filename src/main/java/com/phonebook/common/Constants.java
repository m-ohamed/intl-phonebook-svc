package com.phonebook.common;

public class Constants {
    /*
    This class holds all the constants used throughout the application. This allows it to be easily and quickly changed
    if there are any changes to it. Usually this would be a lookup that resides in the database.
     */
    public static final String CAMEROON_COUNTRY_CODE = "237";
    public static final String ETHIOPIA_COUNTRY_CODE = "251";
    public static final String MOROCCO_COUNTRY_CODE = "212";
    public static final String MOZAMBIQUE_COUNTRY_CODE = "258";
    public static final String UGANDA_COUNTRY_CODE = "256";
    public static final String INVALID_COUNTRY_CODE = "-";

    public static final String CAMEROON_NUMBER_REGEX = "\\(" + CAMEROON_COUNTRY_CODE + "\\)\\ ?[2368]\\d{7,8}$";
    public static final String ETHIOPIA_NUMBER_REGEX = "\\(" + ETHIOPIA_COUNTRY_CODE + "\\)\\ ?[1-59]\\d{8}$";
    public static final String MOROCCO_NUMBER_REGEX = "\\(" + MOROCCO_COUNTRY_CODE + "\\)\\ ?[5-9]\\d{8}$";
    public static final String MOZAMBIQUE_NUMBER_REGEX = "\\(" + MOZAMBIQUE_COUNTRY_CODE + "\\)\\ ?[28]\\d{7,8}$";
    public static final String UGANDA_NUMBER_REGEX = "\\(" + UGANDA_COUNTRY_CODE + "\\)\\ ?\\d{9}$";

    public static final String CAMEROON_COUNTRY_NAME = "Cameroon";
    public static final String ETHIOPIA_COUNTRY_NAME = "Ethiopia";
    public static final String MOROCCO_COUNTRY_NAME = "Morocco";
    public static final String MOZAMBIQUE_COUNTRY_NAME = "Mozambique";
    public static final String UGANDA_COUNTRY_NAME = "Uganda";
    public static final String INVALID_COUNTRY_NAME = "-";
}
