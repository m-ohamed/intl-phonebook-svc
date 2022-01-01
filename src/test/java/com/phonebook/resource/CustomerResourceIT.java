package com.phonebook.resource;

import com.phonebook.Utilities;
import com.phonebook.repository.boundary.CustomerRepository;
import com.phonebook.repository.entity.CustomerEntity;
import com.phonebook.resource.entity.CustomerModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static com.phonebook.common.Constants.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerResourceIT {
    private static final String CUSTOMERS_API = "/customer";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testCorrectData() throws Exception {
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(new CustomerEntity(1, "ABC", "(212) 654642448", "", "")));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(CUSTOMERS_API + "/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        CustomerModel[] customerModel = Utilities.getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), CustomerModel[].class);
        Assertions.assertEquals(MOROCCO_COUNTRY_NAME, customerModel[0].getCountry());
        Assertions.assertEquals(MOROCCO_COUNTRY_CODE, customerModel[0].getCountryCode());
        Assertions.assertTrue(customerModel[0].isState());
    }

    @Test
    public void testInvalidPhoneNumber() throws Exception {
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(new CustomerEntity(1, "ABC", "(212) 654ABCD48", "", "")));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(CUSTOMERS_API + "/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        CustomerModel[] customerModel = Utilities.getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), CustomerModel[].class);
        Assertions.assertEquals(MOROCCO_COUNTRY_NAME, customerModel[0].getCountry());
        Assertions.assertEquals(MOROCCO_COUNTRY_CODE, customerModel[0].getCountryCode());
        Assertions.assertFalse(customerModel[0].isState());
    }

    @Test
    public void testInvalidCountryCode() throws Exception {
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(new CustomerEntity(1, "ABC", "(ABC) 654642448", "", "")));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(CUSTOMERS_API + "/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        CustomerModel[] customerModel = Utilities.getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), CustomerModel[].class);
        Assertions.assertEquals(INVALID_COUNTRY_NAME, customerModel[0].getCountry());
        Assertions.assertEquals(INVALID_COUNTRY_CODE, customerModel[0].getCountryCode());
        Assertions.assertFalse(customerModel[0].isState());
    }

    @Test
    public void testNoContent() throws Exception {
        Mockito.when(customerRepository.findAll()).thenReturn(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders.get(CUSTOMERS_API + "/")).andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
