package com.istad.restaurant.api.order.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateCustomerDto(@Nullable
                                @NotBlank
                                @Length(min = 3, max = 25)
                                String firstName,
                                @Nullable
                                @NotBlank
                                @Length(min = 3, max = 25)
                                String lastName,
                                @Nullable
                                @NotBlank
                                @Length(min = 1, max = 6)
                                String gender,

                                LocalDate dob,
                                @Nullable
                                @NotBlank
                                @Length(min = 8)
                                String contact,
                                @Nullable
                                @NotBlank
                                @Length(min = 6)
                                String address,
                                @Nullable
                                @NotBlank
                                @Length(max = 80)
                                String email) {
}
