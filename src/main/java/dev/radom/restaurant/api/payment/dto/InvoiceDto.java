package dev.radom.restaurant.api.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InvoiceDto(String uuid,
                         String orderUuid,
                         LocalDateTime paymentDate,
                         String paymentMethod,
                         String status,
                         Boolean isPaid,
                         Integer discPct,
                         BigDecimal other) {
}
