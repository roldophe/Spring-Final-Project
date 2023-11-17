package dev.radom.restaurant.api.order.dto;

import java.time.LocalDate;

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
