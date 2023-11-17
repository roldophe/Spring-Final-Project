package dev.radom.restaurant.api.menu;

import dev.radom.restaurant.api.menu.web.*;
import dev.radom.restaurant.api.menu.web.AddMenuDto;
import dev.radom.restaurant.api.menu.web.MenuDto;
import dev.radom.restaurant.api.menu.web.UpdateMenuDto;

import java.util.List;

public interface MenuService {
    void insertMenu(AddMenuDto addMenuDto);

    void updateMenuById(Integer updateId, UpdateMenuDto updateMenuDto);

    void deleteMenuById(Integer deleteId);

    MenuDto findMenuByName(String name);

    List<MenuDto> findAllMenus();

    MenuDto findMenuById(Integer id);

}
