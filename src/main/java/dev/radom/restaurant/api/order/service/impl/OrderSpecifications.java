package dev.radom.restaurant.api.order.service.impl;

import dev.radom.restaurant.api.menu.Item;
import dev.radom.restaurant.api.order.model.Order;
import org.springframework.data.jpa.domain.Specification;

// Define your specifications
public class OrderSpecifications {
    public static Specification<Order> withUuid(String uuid) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("uuid"), uuid);
    }

    public static Specification<Order> withCrewId(Long crewId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("crew").get("id"), crewId);
    }

    public static Specification<Order> withCustomerId(Long customerId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("customer").get("id"), customerId);
    }

    public Specification<Item> withItemId(Integer itemId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("item").get("id"), itemId);
    }
    // Add more specifications as per your requirements
}
