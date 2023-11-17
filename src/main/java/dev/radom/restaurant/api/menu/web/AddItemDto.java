package dev.radom.restaurant.api.menu.web;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AddItemDto(@NotBlank
                         @Size(min = 5, max = 50)
                         String name,
                         @DecimalMin(value = "0.0", inclusive = false)
                         BigDecimal price,
                         @NotBlank
                         @Size(min = 10, max = 200)
                         String image,
                         @NotNull
                         @Positive
                         Integer menuId) {
}
