package dev.radom.restaurant.api.payment.service;

import dev.radom.restaurant.api.order.dto.OrderDto;
import dev.radom.restaurant.api.order.dto.OrderItemDto;
import dev.radom.restaurant.api.order.service.OrderService;
import dev.radom.restaurant.api.payment.Invoice;
import dev.radom.restaurant.api.payment.InvoiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceDetailImpl implements InvoiceDetailService {

    private final OrderService orderService;

    @Override
    public InvoiceDetail addInvoiceDetail(Invoice invoice) {
        OrderDto orderDto = orderService.findOrderByUuid(invoice.getOrder().getUuid());
        BigDecimal subTotal = BigDecimal.ZERO;
        List<OrderItemDto> orderItemDtos = orderDto.orderItems();
        subTotal = orderItemDtos.stream()
                .map(item -> item.price().multiply(BigDecimal.valueOf(item.qty())))
                .reduce(subTotal, BigDecimal::add);
        Integer discPct = (invoice.getDiscPct());
        var disAmt = subTotal.multiply(BigDecimal.valueOf(discPct)).divide(BigDecimal.valueOf(100));
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setDiscAmt(disAmt);
        invoiceDetail.setSubTotal(subTotal);
        invoice.setFinalTotal(subTotal.subtract(disAmt).add(invoice.getOther()));
        invoiceDetail.setInvoice(invoice);
        return invoiceDetail;
    }
}
