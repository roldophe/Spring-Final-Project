package dev.radom.restaurant.api.payment.dto;

import dev.radom.restaurant.api.payment.Invoice;

import java.math.BigDecimal;

public record InvoiceDetailDto(InvoiceDto invoice,
                               BigDecimal discAmt,
                               BigDecimal subTotal,
                               BigDecimal finalTotal) {
}
