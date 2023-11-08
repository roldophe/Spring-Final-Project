package com.istad.restaurant.api.payment.dto;

import com.istad.restaurant.api.payment.dto.InvoiceRequest;
import com.istad.restaurant.api.payment.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;
    @PostMapping("/{orderUuid}")
    public void addInvoice(@PathVariable("orderUuid") String orderUuid, @RequestBody InvoiceRequest invoiceRequest){
        invoiceService.addInvoice(orderUuid,invoiceRequest);
    }
    @GetMapping
    public List<InvoiceDetailDto> getAll(){
        return invoiceService.findAllInvoices();
    }
}
