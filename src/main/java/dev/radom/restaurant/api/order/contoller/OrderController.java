package dev.radom.restaurant.api.order.contoller;

import dev.radom.restaurant.api.order.dto.AddOrderItemDto;
import dev.radom.restaurant.api.order.dto.OrderDto;
import dev.radom.restaurant.api.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    void addOrder(@RequestBody AddOrderItemDto addOrderItemDto) {
        orderService.addOrder(addOrderItemDto);
    }

    @GetMapping
    List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{uuid}")
    OrderDto findOrderByUuid(@PathVariable String uuid) {
        return orderService.findOrderByUuid(uuid);
    }
    @GetMapping("/code/{code}")
    public OrderDto getOrderByCode(@PathVariable String code) {
        return orderService.findOrderByCode(code);
    }

    @DeleteMapping("/{uuid}")
    void deleteOrderByUuid(@PathVariable String uuid) {
        orderService.deleteOrderByUuid(uuid);
    }
}
