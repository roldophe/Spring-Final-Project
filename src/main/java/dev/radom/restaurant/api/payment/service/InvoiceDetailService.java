package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.payment.Invoice;
import dev.radom.restaurant.api.payment.InvoiceDetail;

public interface InvoiceDetailService {
    InvoiceDetail addInvoiceDetail(Invoice invoice);
}
