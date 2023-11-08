package com.istad.restaurant.api.payment.service;

import com.istad.restaurant.api.payment.dto.InvoiceDetailDto;
import com.istad.restaurant.api.payment.dto.InvoiceDto;
import com.istad.restaurant.api.payment.dto.InvoiceRequest;

import java.util.List;

public interface InvoiceService {
    void addInvoice(String orderUuid, InvoiceRequest invoiceRequest);
    List<InvoiceDetailDto> findAllInvoices();
}
