package com.istad.restaurant.api.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.List;

@Builder
public record AddOrderItemDto(@Positive
                              Long customerId,
                              @Positive
                              Long crewId,
                              List<AddOrderDetailDto> orders,
                              String status) {
}
