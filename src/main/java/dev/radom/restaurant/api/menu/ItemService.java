package dev.radom.restaurant.api.menu;

import dev.radom.restaurant.api.menu.web.AddItemDto;
import dev.radom.restaurant.api.menu.web.ItemDto;
import dev.radom.restaurant.api.menu.web.UpdateItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> findByMenuId(Integer menuId);

    ItemDto findItemByUuid(String uuid);

    void deleteItemByUuid(String uuid);

    void updateItemByUuid(String uuid, UpdateItemDto updateItemDto);

    List<ItemDto> findAll();

    void createItem(AddItemDto addItemDto);

    void UpdateIsPresentByUuid(String uuid, Boolean status);
}
