package dev.radom.restaurant.api.order.repository;

import dev.radom.restaurant.api.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByCode(String code);
    Optional<Order> findOrderByUuid(String uuid);
    //List<Order> findAllBySpecificationOrder(Specification<Order> specification);
}
