package dev.radom.restaurant.api.order.service.impl;

import dev.radom.restaurant.api.order.dto.CreateCustomerDto;
import dev.radom.restaurant.api.order.dto.CustomerDto;
import dev.radom.restaurant.api.order.dto.UpdateCustomerDto;
import dev.radom.restaurant.api.order.mapper.CustomerMapper;
import dev.radom.restaurant.api.order.model.Customer;
import dev.radom.restaurant.api.order.repository.CustomerRepository;
import dev.radom.restaurant.api.order.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void createCustomer(CreateCustomerDto createCustomerDto) {
        boolean exist = customerRepository.existsByFirstNameAndLastNameAndDob(
                createCustomerDto.firstName(),
                createCustomerDto.lastName(),
                createCustomerDto.dob()
        );
        if (exist) throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer already exist.");

        Customer newCustomer = customerMapper.fromCreateCustomerDto(createCustomerDto);
        newCustomer.setUuid(UUID.randomUUID().toString());
        newCustomer.setIsDeleted(false);
        newCustomer.setAge(Period.between(newCustomer.getDob(), LocalDate.now()).getYears());
        customerRepository.save(newCustomer);
    }

    @Override
    public void updateCustomerByUuid(String uuid, UpdateCustomerDto updateCustomerDto) {
        Customer IsFound = customerRepository.findCustomerByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The uuid customer that you tried to reach does not exist.")
        );
        customerMapper.fromUpdateCustomerDto(IsFound, updateCustomerDto);
        customerRepository.save(IsFound);
    }

    @Override
    public CustomerDto getCustomerByUuid(String uuid) {
        Customer IsFound = customerRepository.findCustomerByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The uuid customer that you tried to reach does not exist.")
        );
        return customerMapper.toCustomerDto(IsFound);
    }

    @Override
    public void deleteCustomerByUuid(String uuid) {
        Customer IsFound = customerRepository.findCustomerByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The uuid customer that you tried to reach does not exist.")
        );
        customerRepository.delete(IsFound);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerMapper.toCustomerDtoList(customerRepository.findAll());
    }
}
