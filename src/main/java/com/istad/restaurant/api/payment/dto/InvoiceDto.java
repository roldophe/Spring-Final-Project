package com.istad.restaurant.api.payment.dto;

import com.istad.restaurant.api.order.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InvoiceDto(String uuid,
                         LocalDateTime paymentDate,
                         String paymentMethod,
                         Integer discPct,
                         BigDecimal other,
                         String orderUuid,
                         BigDecimal finalTotal,
                         String status,
                         Boolean isPaid) {
}
