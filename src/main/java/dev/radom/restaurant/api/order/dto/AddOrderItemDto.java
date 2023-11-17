package dev.radom.restaurant.api.order.dto;

import jakarta.validation.constraints.NotBlank;
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
                              @NotNull
                              @NotBlank
                              String status) {
}
