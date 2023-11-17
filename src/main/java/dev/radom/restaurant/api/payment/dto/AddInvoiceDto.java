package dev.radom.restaurant.api.payment.dto;

import dev.radom.restaurant.api.order.model.Order;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record AddInvoiceDto(Date paymentDate,
                            BigDecimal finalTotal,
                            Order order,
                            Boolean isPaid,
                            InvoiceRequest invoiceRequest) {
}
