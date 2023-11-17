package dev.radom.restaurant.api.menu.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddItemDto(@NotBlank(message = "Name is required!")
                         @Size(min = 5, max = 50)
                         String name,
                         @NotNull(message = "Price is required!")
                         BigDecimal price,
                         @NotBlank
                         String image,
                         @NotNull(message = "Manu ID is required!")
                         @Positive(message = "Manu ID must be greater than 0")
                         Integer menuId) {
}
