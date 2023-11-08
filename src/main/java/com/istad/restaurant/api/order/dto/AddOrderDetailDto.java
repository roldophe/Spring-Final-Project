package com.istad.restaurant.api.order.dto;


import jakarta.validation.constraints.Positive;

public record AddOrderDetailDto(@Positive Integer itemId,
                                @Positive Integer qty) {
}
