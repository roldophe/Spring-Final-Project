package dev.radom.restaurant.api.order.dto;

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
