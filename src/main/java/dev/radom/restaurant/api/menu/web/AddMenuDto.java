package dev.radom.restaurant.api.menu.web;

import jakarta.validation.constraints.Size;

public record AddMenuDto(@Size(min = 3, max = 20, message = "name must be between 3 and 50 characters")
                         String name,
                         @Size(min = 5, max = 200, message = "About Me must be between 10 and 200 characters")
                         String description) {
}
