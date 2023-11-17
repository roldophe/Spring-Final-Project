package dev.radom.restaurant.api.order.service;

import dev.radom.restaurant.api.order.dto.AddOrderItemDto;
import dev.radom.restaurant.api.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void addOrder(AddOrderItemDto addOrderItemDto);

    List<OrderDto> getAllOrders();

    OrderDto findOrderByCode(String code);

    OrderDto findOrderByUuid(String uuid);

    void deleteOrderByUuid(String uuid);
}
