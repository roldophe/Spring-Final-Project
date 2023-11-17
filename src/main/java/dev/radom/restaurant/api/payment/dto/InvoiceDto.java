package dev.radom.restaurant.api.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InvoiceDto(String uuid,
                         String orderUuid,
                         LocalDateTime paymentDate,
                         String paymentMethod,
                         Integer discPct,
                         BigDecimal discAmt,
                         BigDecimal subTotal,
                         BigDecimal other,
                         BigDecimal finalTotal,
                         String status,
                         Boolean isPaid) {
}
