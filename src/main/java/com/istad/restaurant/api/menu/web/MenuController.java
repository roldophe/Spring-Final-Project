package com.istad.restaurant.api.menu.web;

import com.istad.restaurant.api.menu.ItemService;
import com.istad.restaurant.api.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;
    private final ItemService itemService;

    @GetMapping
    public List<MenuDto> finAllMenus() {
        return menuService.findAllMenus();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMenu(@RequestBody AddMenuDto addMenuDto) {
        menuService.insertMenu(addMenuDto);
    }

    @GetMapping("/{menuId}/items")
    public List<ItemDto> findItemByMenuId(@PathVariable Integer menuId) {
        return itemService.findByMenuId(menuId);
    }

    @GetMapping("/{id}")
    public MenuDto getMenuById(@PathVariable Integer id) {
        return menuService.findMenuById(id);
    }

    @GetMapping("/by-name/{name}")
    public MenuDto getMenuByName(@PathVariable("name") String name) {
        return menuService.findMenuByName(name);
    }

    @PatchMapping("/{id}")
    public void updateManuById(@PathVariable Integer id,
                               @RequestBody UpdateMenuDto updateMenuDto) {
        menuService.updateMenuById(id, updateMenuDto);
    }

    @DeleteMapping("/{id}")
    public void deleteManuById(@PathVariable Integer id) {
        menuService.deleteMenuById(id);
    }
}
