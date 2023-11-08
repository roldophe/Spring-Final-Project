package com.istad.restaurant.api.order.contoller;

import com.istad.restaurant.api.order.dto.*;
import com.istad.restaurant.api.order.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCrewDtos() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{uuid}")
    public CustomerDto getCrewByUuid(@PathVariable String uuid) {
        return customerService.getCustomerByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCrewByUuid(@PathVariable String uuid
            , @RequestBody UpdateCustomerDto updateCustomerDto) {
        customerService.updateCustomerByUuid(uuid, updateCustomerDto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCrewByUuid(@PathVariable String uuid) {
        customerService.deleteCustomerByUuid(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCrew(@RequestBody @Valid CreateCustomerDto createCustomerDto) {
        customerService.createCustomer(createCustomerDto);
    }
}
