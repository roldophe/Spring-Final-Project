package com.istad.restaurant.api.order.repository;

import com.istad.restaurant.api.order.dto.OrderDto;
import com.istad.restaurant.api.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByCode(String code);
    Optional<Order> findOrderByUuid(String uuid);
    //List<Order> findAllBySpecificationOrder(Specification<Order> specification);
}
