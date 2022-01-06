package com.phonebook.repository.boundary;

import com.phonebook.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    /*
    This interface extends the JpaRepository interface which enables us to access the data in the database. The
    JpaRepository interface provides us with the most used CRUD methods for easy and quick data access.
     */
}
