package dev.radom.restaurant.api.order.mapper;

import dev.radom.restaurant.api.order.dto.*;
import dev.radom.restaurant.api.order.dto.*;
import dev.radom.restaurant.api.order.model.Order;
import dev.radom.restaurant.api.order.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "addOrderItemDto.crewId", target = "crew.id")
    @Mapping(source = "addOrderItemDto.customerId", target = "customer.id")
    Order mapAddOrderItemDtoToOrder(AddOrderItemDto addOrderItemDto);

    List<OrderDto> toOrderDtoList(List<Order> orders);

    @Mapping(source = "customer.uuid", target = "customerUuid")
    @Mapping(source = "crew.uuid", target = "crewUuid")
    OrderDto toOrderDto(Order order);

    @Mapping(source = "orderDetail.order.id", target = "orderId")
    @Mapping(source = "orderDetail.item.id", target = "itemId")
    OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

    List<OrderDetailDto> toOrderDetailDtoList(List<OrderDetail> orderDetail);

    @Mapping(source = "addOrderDetailDto.itemId", target = "item.id")
    OrderDetail mapAddOrderDetailDtoToOrderDetail(AddOrderDetailDto addOrderDetailDto);
    default OrderDto toOrderDto(Order order, List<OrderItemDto> orderItemDtos) {
        return OrderDto.builder()
                .uuid(order.getUuid())
                .code(order.getCode())
                .orderDate(order.getOrderDate())
                .customerUuid(order.getCustomer().getUuid())
                .crewUuid(order.getCrew().getUuid())
                .orderItems(orderItemDtos)
                .status(order.getStatus())
                .build();
    }
}