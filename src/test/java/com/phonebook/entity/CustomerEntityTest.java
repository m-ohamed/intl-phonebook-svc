package com.phonebook.entity;

import com.phonebook.common.Constants;
import com.phonebook.repository.entity.CustomerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerEntityTest {
    @Test
    public void testCameroonPhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(237) 673122155");

        Assertions.assertEquals(Constants.CAMEROON_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.CAMEROON_COUNTRY_CODE, customer.getCountryCode());
    }

    @Test
    public void testEthiopiaPhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(251) 914701723");

        Assertions.assertEquals(Constants.ETHIOPIA_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.ETHIOPIA_COUNTRY_CODE, customer.getCountryCode());
    }

    @Test
    public void testMoroccoPhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(212) 654642448");

        Assertions.assertEquals(Constants.MOROCCO_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.MOROCCO_COUNTRY_CODE, customer.getCountryCode());
    }

    @Test
    public void testMozambiquePhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(258) 847651504");

        Assertions.assertEquals(Constants.MOZAMBIQUE_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.MOZAMBIQUE_COUNTRY_CODE, customer.getCountryCode());
    }

    @Test
    public void testUgandaPhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(256) 775069443");

        Assertions.assertEquals(Constants.UGANDA_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.UGANDA_COUNTRY_CODE, customer.getCountryCode());
    }

    @Test
    public void testInvalidPhone() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPhone("(123) 1234567890");

        Assertions.assertEquals(Constants.INVALID_COUNTRY_NAME, customer.getCountry());
        Assertions.assertEquals(Constants.INVALID_COUNTRY_CODE, customer.getCountryCode());
    }
}
