package com.istad.restaurant.api.menu;

import com.istad.restaurant.api.menu.web.AddItemDto;
import com.istad.restaurant.api.menu.web.ItemDto;
import com.istad.restaurant.api.menu.web.UpdateItemDto;

import javax.swing.text.html.Option;
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
