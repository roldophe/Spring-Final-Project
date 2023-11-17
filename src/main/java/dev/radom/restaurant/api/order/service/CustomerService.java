package dev.radom.restaurant.api.order.service;

import dev.radom.restaurant.api.order.dto.CreateCustomerDto;
import dev.radom.restaurant.api.order.dto.CustomerDto;
import dev.radom.restaurant.api.order.dto.UpdateCustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CreateCustomerDto createCustomerDto);

    void updateCustomerByUuid(String uuid, UpdateCustomerDto updateCustomerDto);

    CustomerDto getCustomerByUuid(String uuid);

    void deleteCustomerByUuid(String uuid);

    List<CustomerDto> getAllCustomers();
}
