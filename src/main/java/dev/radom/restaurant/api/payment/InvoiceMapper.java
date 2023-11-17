package dev.radom.restaurant.api.payment;

import dev.radom.restaurant.api.payment.dto.AddInvoiceDto;
import dev.radom.restaurant.api.payment.dto.InvoiceDto;
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
    List<InvoiceDto> toInvoiceDtoList(List<InvoiceDetail> invoiceDetails);
    @Mapping(source = "invoiceDetail.invoice.uuid",target = "uuid")
    @Mapping(source = "invoiceDetail.invoice.paymentDate",target = "paymentDate")
    @Mapping(source = "invoiceDetail.invoice.paymentMethod",target = "paymentMethod")
    @Mapping(source = "invoiceDetail.invoice.discPct",target = "discPct")
    @Mapping(source = "invoiceDetail.invoice.other",target = "other")
    @Mapping(source = "invoiceDetail.invoice.finalTotal",target = "finalTotal")
    @Mapping(source = "invoiceDetail.invoice.status",target = "status")
    @Mapping(source = "invoiceDetail.invoice.isPaid",target = "isPaid")
    @Mapping(source = "invoiceDetail.invoice.order.uuid",target = "orderUuid")
    InvoiceDto toInvoiceDto(InvoiceDetail invoiceDetail);
}
