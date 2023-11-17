package dev.radom.restaurant.api.payment.dto;

import java.math.BigDecimal;

public record InvoiceDetailDto(
        BigDecimal discAmt,
        BigDecimal subTotal) {
}
