package dev.radom.restaurant.api.menu.web;

import java.math.BigDecimal;

public record UpdateItemDto(String name,
                            BigDecimal price,
                            String image,
                            Integer menuId) {
}
