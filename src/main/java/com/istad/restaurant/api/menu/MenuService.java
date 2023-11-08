package com.istad.restaurant.api.menu;

import com.istad.restaurant.api.menu.web.*;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void insertMenu(AddMenuDto addMenuDto);

    void updateMenuById(Integer updateId, UpdateMenuDto updateMenuDto);

    void deleteMenuById(Integer deleteId);

    MenuDto findMenuByName(String name);

    List<MenuDto> findAllMenus();

    MenuDto findMenuById(Integer id);

}
