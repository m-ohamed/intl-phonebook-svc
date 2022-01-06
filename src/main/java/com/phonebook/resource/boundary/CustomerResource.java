package com.phonebook.resource.boundary;

import com.phonebook.repository.boundary.CustomerRepository;
import com.phonebook.repository.entity.CustomerEntity;
import com.phonebook.resource.control.CustomerResourceCtrl;
import com.phonebook.resource.entity.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    /*
    This is where the REST API resides. There is currently only one endpoint, a GET endpoint that returns all the
    available customer after performing the validations. If there is no data it returns a 204 no content.
     */

    private CustomerResourceCtrl customerResourceCtrl;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerResource(CustomerResourceCtrl customerResourceCtrl, CustomerRepository customerRepository) {
        this.customerResourceCtrl = customerResourceCtrl;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public ResponseEntity getAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();

        if(customerEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<CustomerModel> customerModels = customerResourceCtrl.getCustomerModelListFromCustomerEntityList(customerEntities);

        return ResponseEntity.ok(customerModels);
    }
}
