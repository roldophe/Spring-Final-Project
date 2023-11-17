package dev.radom.restaurant.api.order.dto;

public record OrderDetailDto(Integer itemId,
                             Integer qty,
                             Integer orderId) {
}
