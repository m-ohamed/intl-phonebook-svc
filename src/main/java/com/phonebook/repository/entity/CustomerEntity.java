package com.phonebook.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.regex.Pattern;

import static com.phonebook.common.Constants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
public class CustomerEntity {
    @Id
    private Integer id;
    private String name;
    private String phone;

    @Transient
    private String country;

    @Transient
    private String countryCode;

    public String getCountry() {
        if(country == null || country.isBlank())
            updateCountryInformation();

        return country;
    }

    public String getCountryCode() {
        if(countryCode == null || countryCode.isBlank())
            updateCountryInformation();

        return countryCode;
    }

    private void updateCountryInformation() {
        if(phone.contains("(" + CAMEROON_COUNTRY_CODE + ")")) {
            country = CAMEROON_COUNTRY_NAME;
            countryCode = CAMEROON_COUNTRY_CODE;
        } else if(phone.contains("(" + ETHIOPIA_COUNTRY_CODE + ")")) {
            country = ETHIOPIA_COUNTRY_NAME;
            countryCode = ETHIOPIA_COUNTRY_CODE;
        } else if(phone.contains("(" + MOROCCO_COUNTRY_CODE + ")")) {
            country = MOROCCO_COUNTRY_NAME;
            countryCode = MOROCCO_COUNTRY_CODE;
        } else if(phone.contains("(" + MOZAMBIQUE_COUNTRY_CODE + ")")) {
            country = MOZAMBIQUE_COUNTRY_NAME;
            countryCode = MOZAMBIQUE_COUNTRY_CODE;
        } else if(phone.contains("(" + UGANDA_COUNTRY_CODE + ")")) {
            country = UGANDA_COUNTRY_NAME;
            countryCode = UGANDA_COUNTRY_CODE;
        } else {
            country = INVALID_COUNTRY_NAME;
            countryCode = INVALID_COUNTRY_CODE;
        }
    }
}
