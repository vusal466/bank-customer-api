package com.example.bankcustomerapi.controllers;

import com.example.bankcustomerapi.dto.CustomerRequest;
import com.example.bankcustomerapi.dto.CustomerResponse;
import com.example.bankcustomerapi.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Customer Management APIs")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "User create")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "409", description = "Username or email exists")})
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "get users by id")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public  ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
