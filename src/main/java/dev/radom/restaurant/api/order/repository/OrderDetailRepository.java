package dev.radom.restaurant.api.order.repository;

import dev.radom.restaurant.api.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findAllByOrder_Id(Long id);

}
