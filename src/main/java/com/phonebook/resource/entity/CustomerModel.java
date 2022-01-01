package com.phonebook.resource.entity;

import lombok.Data;

@Data
public class CustomerModel {
    private String country;
    private boolean state;
    private String countryCode;
    private String phone;
}
