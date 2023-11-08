package com.istad.restaurant.api.order.service.impl;

import com.istad.restaurant.api.order.dto.*;
import com.istad.restaurant.api.order.mapper.OrderMapper;
import com.istad.restaurant.api.order.model.Order;
import com.istad.restaurant.api.order.model.OrderDetail;
import com.istad.restaurant.api.order.repository.OrderDetailRepository;
import com.istad.restaurant.api.order.repository.OrderRepository;
import com.istad.restaurant.api.order.service.OrderService;
import com.istad.restaurant.utils.RandomCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public void addOrder(AddOrderItemDto addOrderItemDto) {
        Order order = orderMapper.mapAddOrderItemDtoToOrder(addOrderItemDto);
        order.setUuid(UUID.randomUUID().toString());
        order.setCode(RandomCode.generateCode());
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
        List<OrderDetail> orderDetails = addOrderItemDto.orders().stream()
                .map(item -> {
                    OrderDetail orderDetail = orderMapper.mapAddOrderDetailDtoToOrderDetail(item);
                    orderDetail.setOrder(order);
                    return orderDetail;
                })
                .collect(Collectors.toList());
        orderDetailRepository.saveAll(orderDetails);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order ->
                findOrderByUuid(order.getUuid())
        ).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderByUuid(String uuid) {
        List<OrderItemDto> orderItemDtos;
        Order isFound = orderRepository.findOrderByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid order that you tried to reach does not exist."));
        var orderDetails = orderDetailRepository.findAllByOrder_Id(isFound.getId());

        orderItemDtos = orderDetails.stream().map(orderDetail -> OrderItemDto.builder()
                .name(orderDetail.getItem().getName())
                .qty(orderDetail.getQty())
                .price(orderDetail.getItem().getPrice())
                .build()).collect(Collectors.toList());
        return orderMapper.toOrderDto(isFound, orderItemDtos);

    }

    @Override
    public OrderDto findOrderByCode(String code) {
        List<OrderItemDto> orderItemDtos;
        Order isFound = orderRepository.findOrderByCode(code)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The Uuid order that you tried to reach does not exist."));
        var orderDetails = orderDetailRepository.findAllByOrder_Id(isFound.getId());

        orderItemDtos = orderDetails.stream().map(orderDetail -> OrderItemDto.builder()
                .name(orderDetail.getItem().getName())
                .qty(orderDetail.getQty())
                .price(orderDetail.getItem().getPrice())
                .build()).collect(Collectors.toList());
        return orderMapper.toOrderDto(isFound, orderItemDtos);
    }

    @Override
    public void deleteOrderByUuid(String uuid) {
        // Retrieve the order by UUID
        Order order = orderRepository.findOrderByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "The UUID order that you tried to reach does not exist."));
        // Delete the order
        orderRepository.delete(order);
    }


}
