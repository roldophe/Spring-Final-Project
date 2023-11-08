package com.istad.restaurant.api.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByMenuId(Integer menuId);

    Optional<Item> findItemByUuid(String uuid);

    //Optional<Item> findItemByUuidAndStatusIsFalse(String uuid, Boolean status);

    Optional<Item> findItemByName(String name);

    //List<Item> findAllByStatusIsTrue(Boolean status);
}
