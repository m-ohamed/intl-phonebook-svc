package com.phonebook.resource;

import com.phonebook.resource.control.CustomerResourceCtrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerResourceCtrlTest {
    @Autowired
    private CustomerResourceCtrl customerResourceCtrl;

    @Test
    public void invalidCustomerNumber() {
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("1234567890"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("ABCDEFGH"));
    }

    @Test
    public void cameroonCustomerNumber() {
        Assertions.assertTrue(customerResourceCtrl.validateCustomerNumber("(237) 673122155"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(237) 6770466161"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(237) 673l22155"));
    }

    @Test
    public void ethiopiaCustomerNumber() {
        Assertions.assertTrue(customerResourceCtrl.validateCustomerNumber("(251) 914701723"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(251) 9773199405"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(251) 9147O1723"));
    }

    @Test
    public void moroccoCustomerNumber() {
        Assertions.assertTrue(customerResourceCtrl.validateCustomerNumber("(212) 654642448"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(212) 6617344445"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(212) 6A7344445"));
    }

    @Test
    public void mozambiqueCustomerNumber() {
        Assertions.assertTrue(customerResourceCtrl.validateCustomerNumber("(258) 847651504"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(258) 84330678235"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(258) 8476515O4"));
    }

    @Test
    public void ugandaCustomerNumber() {
        Assertions.assertTrue(customerResourceCtrl.validateCustomerNumber("(256) 775069443"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(256) 7734127498"));
        Assertions.assertFalse(customerResourceCtrl.validateCustomerNumber("(256) 7503O6263"));
    }
}
