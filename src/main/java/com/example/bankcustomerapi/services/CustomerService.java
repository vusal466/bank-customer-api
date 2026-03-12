package com.example.bankcustomerapi.services;

import com.example.bankcustomerapi.dto.CustomerRequest;
import com.example.bankcustomerapi.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);
    CustomerResponse getCustomerById(Long id);
    List<CustomerResponse> getAllCustomers();
}
