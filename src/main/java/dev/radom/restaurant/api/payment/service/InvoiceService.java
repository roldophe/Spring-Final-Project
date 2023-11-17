package dev.radom.restaurant.api.payment.service;
import dev.radom.restaurant.api.payment.dto.InvoiceDetailDto;
import dev.radom.restaurant.api.payment.dto.InvoiceDto;
import dev.radom.restaurant.api.payment.dto.InvoiceRequest;
import dev.radom.restaurant.api.payment.dto.UpdateInvoiceDto;

import java.util.List;

public interface InvoiceService {
    void addInvoice(String orderUuid, InvoiceRequest invoiceRequest);
    List<InvoiceDetailDto> findAllInvoiceDetails();
    InvoiceDto findInvoiceByUuid(String uuid);
    List<InvoiceDto> findInvoiceIsPaidFalse();
    List<InvoiceDto> findAllInvoices();
    InvoiceDetailDto findInvoiceDetailByInvoiceUuid(String invoiceUuid);
    void updateIsPaid(String invoiceUuid,Boolean isPaid);
    void updateInvoiceByUuid(String uuid, UpdateInvoiceDto updateInvoiceDto);
    void deleteInvoiceByUuid(String uuid);
}
