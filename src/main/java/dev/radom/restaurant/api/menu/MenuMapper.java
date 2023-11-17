package dev.radom.restaurant.api.menu;

import dev.radom.restaurant.api.menu.web.AddMenuDto;
import dev.radom.restaurant.api.menu.web.MenuDto;
import dev.radom.restaurant.api.menu.web.UpdateMenuDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu fromAddMenuDto(AddMenuDto addMenuDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMenuFromDto(UpdateMenuDto updateMenuDto, @MappingTarget Menu menu);

    List<MenuDto> toMenuDtoList(List<Menu> menus);

    MenuDto toMenuDto(Menu menu);
}
