package com.istad.restaurant.api.menu;

import com.istad.restaurant.api.menu.web.AddItemDto;
import com.istad.restaurant.api.menu.web.ItemDto;
import com.istad.restaurant.api.menu.web.UpdateItemDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "menuId",target = "menu.id")
    Item fromCreateItemDto(AddItemDto addItemDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateItemDto(@MappingTarget Item item, UpdateItemDto updateItemDto);
    ItemDto toItemDto(Item item);

    List<ItemDto> toItemDtoList(List<Item> items);

}
