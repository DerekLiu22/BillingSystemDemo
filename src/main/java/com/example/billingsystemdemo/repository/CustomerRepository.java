package com.example.billingsystemdemo.repository;

import com.example.billingsystemdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(
            value = "SELECT * FROM customer WHERE last_name = ?1",
            nativeQuery = true
    )
    List<Customer> getCustomerByLastName(String lastName);
}
