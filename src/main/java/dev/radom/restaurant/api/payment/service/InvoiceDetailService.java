package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.payment.Invoice;
import dev.radom.restaurant.api.payment.InvoiceDetail;
import dev.radom.restaurant.api.payment.dto.InvoiceDetailDto;

import java.util.List;

public interface InvoiceDetailService {
    InvoiceDetail addInvoiceDetail(Invoice invoice);
}
