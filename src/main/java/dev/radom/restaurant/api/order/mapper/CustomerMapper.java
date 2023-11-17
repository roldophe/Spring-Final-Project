package dev.radom.restaurant.api.order.mapper;
import dev.radom.restaurant.api.order.dto.CreateCustomerDto;
import dev.radom.restaurant.api.order.dto.CustomerDto;
import dev.radom.restaurant.api.order.dto.UpdateCustomerDto;
import dev.radom.restaurant.api.order.model.Customer;
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
