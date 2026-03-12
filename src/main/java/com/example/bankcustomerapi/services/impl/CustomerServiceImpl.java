package com.example.bankcustomerapi.services.impl;

import com.example.bankcustomerapi.dto.CustomerRequest;
import com.example.bankcustomerapi.dto.CustomerResponse;
import com.example.bankcustomerapi.entities.Customer;
import com.example.bankcustomerapi.exceptions.CustomerNotFoundException;
import com.example.bankcustomerapi.exceptions.EmailAlreadyExistsException;
import com.example.bankcustomerapi.mapper.CustomerMapper;
import com.example.bankcustomerapi.repositories.CustomerRepository;
import com.example.bankcustomerapi.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        if (customerRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException(request.getEmail());
        }
        Customer saved = customerRepository.save(customerMapper.toEntity(request));
        return customerMapper.toResponse(saved);
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer=customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(id));

        return customerMapper.toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerMapper.toResponseList(customerRepository.findAll());
    }
}
