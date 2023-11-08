package com.istad.restaurant.api.menu;

import com.istad.restaurant.api.menu.web.AddMenuDto;
import com.istad.restaurant.api.menu.web.MenuDto;
import com.istad.restaurant.api.menu.web.UpdateMenuDto;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu fromAddMenuDto(AddMenuDto addMenuDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMenuFromDto(UpdateMenuDto updateMenuDto, @MappingTarget Menu menu);

    List<MenuDto> toMenuDtoList(List<Menu> menus);

    MenuDto toMenuDto(Menu menu);
}
