package com.istad.restaurant.api.order.service;

import com.istad.restaurant.api.order.dto.AddOrderItemDto;
import com.istad.restaurant.api.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void addOrder(AddOrderItemDto addOrderItemDto);

    List<OrderDto> getAllOrders();

    OrderDto findOrderByCode(String code);

    OrderDto findOrderByUuid(String uuid);

    void deleteOrderByUuid(String uuid);
}
