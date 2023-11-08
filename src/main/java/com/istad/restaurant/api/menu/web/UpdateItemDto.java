package com.istad.restaurant.api.menu.web;

import java.math.BigDecimal;
import java.util.Set;

public record UpdateItemDto(String name,
                            BigDecimal price,
                            String image,
                            Integer menuId) {
}
