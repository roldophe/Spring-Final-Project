package dev.radom.restaurant.api.payment;

import dev.radom.restaurant.api.payment.dto.AddInvoiceDto;
import dev.radom.restaurant.api.payment.dto.InvoiceDetailDto;
import dev.radom.restaurant.api.payment.dto.InvoiceDto;
import dev.radom.restaurant.api.payment.dto.UpdateInvoiceDto;
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

    @Mapping(source = "updateInvoiceDto.discPct",target = "discPct")
    @Mapping(source = "updateInvoiceDto.other",target = "other")
    @Mapping(source = "updateInvoiceDto.status",target = "status")
    Invoice fromUpdateInvoiceDto(Invoice invoice, UpdateInvoiceDto updateInvoiceDto);
    @Mapping(source = "invoice.order.uuid",target = "orderUuid")
    InvoiceDto toInvoiceDto(Invoice invoice);
    List<InvoiceDto> toInvoiceDtoList(List<Invoice> invoiceDtoList);

    @Mapping(source = "invoiceDetail.invoice",target = "invoice")
    InvoiceDetailDto toInvoiceDetailDto(InvoiceDetail invoiceDetail);
    List<InvoiceDetailDto> toInvoiceDetailDtoList(List<InvoiceDetail> invoices);
}
