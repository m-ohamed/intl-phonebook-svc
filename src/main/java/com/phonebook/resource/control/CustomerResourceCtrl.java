package com.phonebook.resource.control;

import com.phonebook.common.Utilities;
import com.phonebook.repository.entity.CustomerEntity;
import com.phonebook.resource.entity.CustomerModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.phonebook.common.Constants.*;

@Component
public class CustomerResourceCtrl {
    /*
    This is where all the business logic related to the customer resource takes place.
     */

    //This maps from a customer entity list to a customer model list
    public List<CustomerModel> getCustomerModelListFromCustomerEntityList(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(this::getCustomerModelFromCustomerEntity).collect(Collectors.toList());
    }

    //This method tries to match the given phone number to one of the provided regular expressions.
    public boolean validateCustomerNumber(String phoneNumber) {
        return Pattern.matches(CAMEROON_NUMBER_REGEX + "|" + ETHIOPIA_NUMBER_REGEX + "|"
                + MOROCCO_NUMBER_REGEX + "|" + MOZAMBIQUE_NUMBER_REGEX + "|" + UGANDA_NUMBER_REGEX, phoneNumber);
    }

    //This method maps from a single customer entity to a customer model.
    private CustomerModel getCustomerModelFromCustomerEntity(CustomerEntity customer) {
        CustomerModel customerModel = Utilities.getModelMapper().map(customer, CustomerModel.class);
        customerModel.setState(validateCustomerNumber(customerModel.getPhone()));

        return customerModel;
    }
}
