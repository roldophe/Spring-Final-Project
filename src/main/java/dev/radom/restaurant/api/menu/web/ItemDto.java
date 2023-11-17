package dev.radom.restaurant.api.menu.web;

import java.math.BigDecimal;

public record ItemDto(String uuid,
                      String code,
                      String name,
                      Boolean status,
                      BigDecimal price,
                      String image) {
}
