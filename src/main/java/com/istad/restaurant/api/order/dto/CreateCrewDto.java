package com.istad.restaurant.api.order.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateCrewDto(@Nullable
                            @NotBlank
                            @Size(min = 3, max = 25)
                            String firstName,
                            @Nullable
                            @Size(min = 3, max = 25)
                            @NotBlank
                            String lastName,
                            @Nullable
                            @NotBlank
                            @Size(min = 1, max = 6)
                            String gender,
                            @Nullable
                            LocalDate dob,
                            @NotBlank
                            @Nullable
                            @Size(min = 9, max = 20)
                            String contact,
                            @NotBlank
                            @Size(min = 6)
                            String address,
                            @NotBlank
                            @Email
                            String email) {
}
