package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.order.model.Order;
import dev.radom.restaurant.api.order.repository.OrderRepository;
import dev.radom.restaurant.api.payment.dto.*;
import dev.radom.restaurant.api.payment.Invoice;
import dev.radom.restaurant.api.payment.InvoiceDetail;
import dev.radom.restaurant.api.payment.InvoiceMapper;
import dev.radom.restaurant.api.payment.repository.InvoiceDetailRepository;
import dev.radom.restaurant.api.payment.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final OrderRepository orderRepository;
    private final InvoiceMapper invoiceMapper;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailService invoiceDetailService;
    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    @Transactional
    public void addInvoice(String orderUuid, InvoiceRequest invoiceRequest) {
        Order order = orderRepository.findOrderByUuid(orderUuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The uuid order does not exist."));
        var addInvoiceDto = AddInvoiceDto.builder().invoiceRequest(invoiceRequest).build();
        Boolean existOrderById = invoiceRepository.existsInvoiceByOrder_Id(order.getId());
        if (existOrderById) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "The uuid order already exist.");
        }
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
    public List<InvoiceDetailDto> findAllInvoiceDetails() {
        return invoiceMapper.toInvoiceDetailDtoList(invoiceDetailRepository.findAll());
    }

    @Override
    public InvoiceDetailDto findInvoiceDetailByInvoiceUuid(String invoiceUuid) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findInvoiceDetailByInvoice_Uuid(invoiceUuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid Invoice does not exist."));
        return invoiceMapper.toInvoiceDetailDto(invoiceDetail);
    }

    @Override
    @Transactional
    public void updateIsPaid(String invoiceUuid, Boolean isPaid) {
        Invoice invoice = invoiceRepository.findInvoiceByUuid(invoiceUuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid Invoice does not exist."));
        invoice.setIsPaid(isPaid);
        invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceDto findInvoiceByUuid(String uuid) {
        Invoice invoice = invoiceRepository.findInvoiceByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid Invoice does not exist."));

        return invoiceMapper.toInvoiceDto(invoice);
    }

    @Override
    public List<InvoiceDto> findAllInvoices() {
        return invoiceMapper.toInvoiceDtoList(invoiceRepository.findAll());
    }

    @Override
    @Transactional
    public void updateInvoiceByUuid(String uuid, UpdateInvoiceDto updateInvoiceDto) {
        Invoice invoice = invoiceRepository.findInvoiceByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid Invoice does not exist."));
        invoice.setPaymentDate(LocalDateTime.now());
        invoiceRepository.save(invoiceMapper.fromUpdateInvoiceDto(invoice, updateInvoiceDto));
    }

    @Override
    @Transactional
    public void deleteInvoiceByUuid(String uuid) {
        Invoice invoice = invoiceRepository.findInvoiceByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid Invoice does not exist."));

        invoiceRepository.delete(invoice);
    }

    @Override
    public List<InvoiceDto> findInvoiceIsPaidFalse() {
        return invoiceMapper.toInvoiceDtoList(invoiceRepository.findInvoiceByIsPaidFalse());
    }
}
