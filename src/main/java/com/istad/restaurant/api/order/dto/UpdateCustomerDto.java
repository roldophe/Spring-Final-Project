package com.istad.restaurant.api.order.dto;

import java.time.LocalDate;

public record UpdateCustomerDto(String firstName,
                                String lastName,
                                String gender,
                                LocalDate dob,
                                String address,
                                String email) {
}
