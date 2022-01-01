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

    @PostLoad
    private void postLoad() {
        if(this.phone.contains("(" + CAMEROON_COUNTRY_CODE + ")")) {
            this.country = CAMEROON_COUNTRY_NAME;
            this.countryCode = CAMEROON_COUNTRY_CODE;
        } else if(this.phone.contains("(" + ETHIOPIA_COUNTRY_CODE + ")")) {
            this.country = ETHIOPIA_COUNTRY_NAME;
            this.countryCode = ETHIOPIA_COUNTRY_CODE;
        } else if(this.phone.contains("(" + MOROCCO_COUNTRY_CODE + ")")) {
            this.country = MOROCCO_COUNTRY_NAME;
            this.countryCode = MOROCCO_COUNTRY_CODE;
        } else if(this.phone.contains("(" + MOZAMBIQUE_COUNTRY_CODE + ")")) {
            this.country = MOZAMBIQUE_COUNTRY_NAME;
            this.countryCode = MOZAMBIQUE_COUNTRY_CODE;
        } else if(this.phone.contains("(" + UGANDA_COUNTRY_CODE + ")")) {
            this.country = UGANDA_COUNTRY_NAME;
            this.countryCode = UGANDA_COUNTRY_CODE;
        } else {
            this.country = INVALID_COUNTRY_NAME;
            this.countryCode = INVALID_COUNTRY_CODE;
        }
    }
}
