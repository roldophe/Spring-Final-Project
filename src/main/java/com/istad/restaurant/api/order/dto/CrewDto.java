package com.istad.restaurant.api.order.dto;

import com.istad.restaurant.api.order.model.Order;

import java.time.LocalDate;
import java.util.List;

public record CrewDto(String uuid,
                      String firstName,
                      String lastName,
                      String gender,
                      LocalDate dob,
                      Integer age,
                      String contact,
                      String address,
                      String email) {
}
