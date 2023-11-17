package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.order.model.Order;
import dev.radom.restaurant.api.order.repository.OrderRepository;
import dev.radom.restaurant.api.payment.dto.AddInvoiceDto;
import dev.radom.restaurant.api.payment.Invoice;
import dev.radom.restaurant.api.payment.InvoiceDetail;
import dev.radom.restaurant.api.payment.InvoiceMapper;
import dev.radom.restaurant.api.payment.dto.InvoiceDto;
import dev.radom.restaurant.api.payment.dto.InvoiceRequest;
import dev.radom.restaurant.api.payment.repository.InvoiceDetailRepository;
import dev.radom.restaurant.api.payment.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final OrderRepository orderRepository;
    private final InvoiceMapper invoiceMapper;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailService invoiceDetailService;
    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public void addInvoice(String orderUuid, InvoiceRequest invoiceRequest) {
        Order order = orderRepository.findOrderByUuid(orderUuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid order that you tried to reach does not exist."));
        var addInvoiceDto = AddInvoiceDto.builder().invoiceRequest(invoiceRequest).build();

        Invoice invoice = invoiceMapper.fromAddInvoiceDto(addInvoiceDto);
        invoice.setIsPaid(false);
        invoice.setUuid(UUID.randomUUID().toString());
        invoice.setOrder(order);
        invoice.setPaymentDate(LocalDateTime.now());
        InvoiceDetail invoiceDetail = invoiceDetailService.addInvoiceDetail(invoice);
        invoiceRepository.save(invoice);
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public List<InvoiceDto> findAllInvoices() {
        return invoiceMapper.toInvoiceDtoList(invoiceDetailRepository.findAll());
    }


}
