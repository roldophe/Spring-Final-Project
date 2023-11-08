package com.istad.restaurant.api.order.dto;

import java.math.BigDecimal;

public record OrderDetailDto(Integer itemId,
                             Integer qty,
                             Integer orderId) {
}
