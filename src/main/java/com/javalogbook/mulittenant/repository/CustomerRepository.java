package com.javalogbook.mulittenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javalogbook.mulittenant.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
