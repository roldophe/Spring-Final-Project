package com.istad.restaurant.api.payment.dto;

import com.istad.restaurant.api.order.model.Order;
import com.istad.restaurant.api.payment.dto.InvoiceRequest;
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
