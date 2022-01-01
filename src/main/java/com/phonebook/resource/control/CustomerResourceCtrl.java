package com.phonebook.resource.control;

import com.phonebook.common.Utilities;
import com.phonebook.repository.entity.CustomerEntity;
import com.phonebook.resource.entity.CustomerModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.phonebook.common.Constants.*;

@Component
public class CustomerResourceCtrl {
    public List<CustomerModel> getCustomerModelListFromCustomerEntityList(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(this::getCustomerModelFromCustomerEntity).collect(Collectors.toList());
    }

    private void updateCustomerDetails(CustomerModel customerModel) {
        if(customerModel.getPhone().contains("(" + CAMEROON_COUNTRY_CODE + ")")) {
            customerModel.setCountry(CAMEROON_COUNTRY_NAME);
            customerModel.setCountryCode(CAMEROON_COUNTRY_CODE);
        } else if(customerModel.getPhone().contains("(" + ETHIOPIA_COUNTRY_CODE + ")")) {
            customerModel.setCountry(ETHIOPIA_COUNTRY_NAME);
            customerModel.setCountryCode(ETHIOPIA_COUNTRY_CODE);
        } else if(customerModel.getPhone().contains("(" + MOROCCO_COUNTRY_CODE + ")")) {
            customerModel.setCountry(MOROCCO_COUNTRY_NAME);
            customerModel.setCountryCode(MOROCCO_COUNTRY_CODE);
        } else if(customerModel.getPhone().contains("(" + MOZAMBIQUE_COUNTRY_CODE + ")")) {
            customerModel.setCountry(MOZAMBIQUE_COUNTRY_NAME);
            customerModel.setCountryCode(MOZAMBIQUE_COUNTRY_CODE);
        } else if(customerModel.getPhone().contains("(" + UGANDA_COUNTRY_CODE + ")")) {
            customerModel.setCountry(UGANDA_COUNTRY_NAME);
            customerModel.setCountryCode(UGANDA_COUNTRY_CODE);
        } else {
            customerModel.setCountry(INVALID_COUNTRY_NAME);
            customerModel.setCountryCode(INVALID_COUNTRY_CODE);
        }
    }

    private CustomerModel getCustomerModelFromCustomerEntity(CustomerEntity customer) {
        CustomerModel customerModel = Utilities.getModelMapper().map(customer, CustomerModel.class);
        updateCustomerDetails(customerModel);

        return customerModel;
    }
}
