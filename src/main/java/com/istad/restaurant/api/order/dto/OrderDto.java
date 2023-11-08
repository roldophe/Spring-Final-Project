package com.istad.restaurant.api.order.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
@Builder
public record OrderDto(String uuid,
                       String code,
                       LocalDateTime orderDate,
                       String customerUuid,
                       String crewUuid,
                       List<OrderItemDto> orderItems,
                       String status) {
}
