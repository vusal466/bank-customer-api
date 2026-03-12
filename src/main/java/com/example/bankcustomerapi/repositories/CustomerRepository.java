package com.example.bankcustomerapi.repositories;

import com.example.bankcustomerapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {



    boolean existsByEmail(String email);

}
