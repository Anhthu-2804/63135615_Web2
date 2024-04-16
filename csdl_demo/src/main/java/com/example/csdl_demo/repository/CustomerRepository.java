package com.example.csdl_demo.repository;

import com.example.csdl_demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer > { // ten thuc the va kieu du lieu truong id

}
