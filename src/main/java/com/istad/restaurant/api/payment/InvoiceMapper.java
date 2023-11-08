package com.istad.restaurant.api.payment;

import com.istad.restaurant.api.payment.dto.AddInvoiceDto;
import com.istad.restaurant.api.payment.dto.InvoiceDetailDto;
import com.istad.restaurant.api.payment.dto.InvoiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    @Mapping(source = "invoiceRequest.paymentMethod",target = "paymentMethod")
    @Mapping(source = "invoiceRequest.other",target = "other")
    @Mapping(source = "invoiceRequest.status",target = "status")
    @Mapping(source = "invoiceRequest.discPct",target = "discPct")
    Invoice fromAddInvoiceDto(AddInvoiceDto addInvoiceDto);
    @Mapping(source = "order.uuid",target = "orderUuid")
    InvoiceDto toInvoiceDto(Invoice invoice);
    List<InvoiceDetailDto> toInvoiceDtoList(List<InvoiceDetail> invoiceDetails);
    @Mapping(source = "invoiceDetail.invoice",target = "invoiceDto")
    InvoiceDetailDto toInvoiceDto(InvoiceDetail invoiceDetail);
}
