package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.payment.dto.InvoiceDto;
import dev.radom.restaurant.api.payment.dto.InvoiceRequest;

import java.util.List;

public interface InvoiceService {
    void addInvoice(String orderUuid, InvoiceRequest invoiceRequest);
    List<InvoiceDto> findAllInvoices();
}
