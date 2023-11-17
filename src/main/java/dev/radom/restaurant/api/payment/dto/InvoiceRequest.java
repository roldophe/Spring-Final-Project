package dev.radom.restaurant.api.payment.dto;

import java.math.BigDecimal;

public record InvoiceRequest(String paymentMethod,
                             BigDecimal other,
                             Integer discPct,
                             String status) {
}
