package com.example.bankcustomerapi.mapper;

import com.example.bankcustomerapi.dto.CustomerRequest;
import com.example.bankcustomerapi.dto.CustomerResponse;
import com.example.bankcustomerapi.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    CustomerResponse toResponse(Customer customer);

    Customer toEntity(CustomerRequest request);

    List<CustomerResponse> toResponseList(List<Customer> customers);

}
