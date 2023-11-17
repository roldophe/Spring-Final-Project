package dev.radom.restaurant.api.payment.dto;

import java.math.BigDecimal;

public record UpdateInvoiceDto(Integer discPct,
                               BigDecimal other,
                               String status) {
}
