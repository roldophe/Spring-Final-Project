package com.istad.restaurant.api.order.service;

import com.istad.restaurant.api.order.dto.CreateCustomerDto;
import com.istad.restaurant.api.order.dto.CustomerDto;
import com.istad.restaurant.api.order.dto.UpdateCustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CreateCustomerDto createCustomerDto);

    void updateCustomerByUuid(String uuid, UpdateCustomerDto updateCustomerDto);

    CustomerDto getCustomerByUuid(String uuid);

    void deleteCustomerByUuid(String uuid);

    List<CustomerDto> getAllCustomers();
}
