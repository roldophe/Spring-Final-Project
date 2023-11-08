package com.istad.restaurant.api.order.mapper;

import com.istad.restaurant.api.order.dto.CreateCustomerDto;
import com.istad.restaurant.api.order.dto.CustomerDto;
import com.istad.restaurant.api.order.dto.UpdateCustomerDto;
import com.istad.restaurant.api.order.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer fromCreateCustomerDto(CreateCustomerDto createCustomerDto);

    void fromUpdateCustomerDto(@MappingTarget Customer customer, UpdateCustomerDto updateCustomerDto);

    CustomerDto toCustomerDto(Customer customer);

    List<CustomerDto> toCustomerDtoList(List<Customer> customers);
}
