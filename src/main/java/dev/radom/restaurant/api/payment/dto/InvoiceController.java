package dev.radom.restaurant.api.payment.dto;

import dev.radom.restaurant.api.payment.service.InvoiceService;
import dev.radom.restaurant.utils.UpdateStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping("/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addInvoice(@PathVariable("uuid") String uuid, @RequestBody @Valid InvoiceRequest invoiceRequest) {
        invoiceService.addInvoice(uuid, invoiceRequest);
    }

    @GetMapping("/{uuid}")
    public InvoiceDto getInvoiceByUuid(@PathVariable("uuid") String uuid) {
        return invoiceService.findInvoiceByUuid(uuid);
    }

    @GetMapping()
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/isPaidFalse")
    public List<InvoiceDto> getAllInvoicesIsPaidFalse() {
        return invoiceService.findInvoiceIsPaidFalse();
    }

    @GetMapping("/details")
    public List<InvoiceDetailDto> getAllInvoiceDetailDtos() {
        return invoiceService.findAllInvoiceDetails();
    }

    @GetMapping("/details/{uuid}")
    public InvoiceDetailDto getInvoiceDetailByInvoiceUuid(@PathVariable("uuid") String uuid) {
        return invoiceService.findInvoiceDetailByInvoiceUuid(uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{uuid}")
    void updateIsPaidByUuid(@PathVariable String uuid,
                            @RequestBody UpdateStatus updateStatus) {
        invoiceService.updateIsPaid(uuid, updateStatus.status());
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{uuid}")
    void updateInvoiceByUuid(@PathVariable String uuid,
                             @RequestBody UpdateInvoiceDto updateInvoiceDto) {
        invoiceService.updateInvoiceByUuid(uuid, updateInvoiceDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    void deleteInvoiceByUuid(@PathVariable String uuid) {
        invoiceService.deleteInvoiceByUuid(uuid);
    }
}
