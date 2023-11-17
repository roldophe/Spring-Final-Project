package dev.radom.restaurant.utils;

import jakarta.validation.constraints.NotBlank;

public record UpdateStatus(@NotBlank
                           Boolean status) {
}
