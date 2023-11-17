package dev.radom.restaurant.api.order.dto;

import java.time.LocalDate;

public record UpdateCrewDto(String firstName,
                            String lastName,
                            String gender,
                            LocalDate dob,
                            String address,
                            String email) {
}
