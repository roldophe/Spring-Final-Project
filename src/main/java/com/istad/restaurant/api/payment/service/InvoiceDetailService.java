package com.istad.restaurant.api.payment.service;

import com.istad.restaurant.api.order.service.OrderService;
import com.istad.restaurant.api.payment.Invoice;
import com.istad.restaurant.api.payment.InvoiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface InvoiceDetailService {
    InvoiceDetail addInvoiceDetail(Invoice invoice);
}
