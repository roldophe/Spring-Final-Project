package dev.radom.restaurant.api.order.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemDto(String name,
                           Integer qty,
                           BigDecimal price) {
}
