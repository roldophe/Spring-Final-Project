package com.istad.restaurant.api.menu;

import com.istad.restaurant.api.menu.web.AddMenuDto;
import com.istad.restaurant.api.menu.web.MenuDto;
import com.istad.restaurant.api.menu.web.UpdateMenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public void insertMenu(AddMenuDto addMenuDto) {
        Menu menu = menuMapper.fromAddMenuDto(addMenuDto);
        menuRepository.save(menu);
    }

    @Override
    public void updateMenuById(Integer updateId, UpdateMenuDto updateMenuDto) {
        Menu IsFound = menuRepository.findById(updateId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Menu ID = %s doesn't exits in db!", updateId))
        );
        menuMapper.updateMenuFromDto(updateMenuDto, IsFound);
        menuRepository.save(IsFound);
    }

    @Override
    public void deleteMenuById(Integer deleteId) {
        boolean exist = menuRepository.existsById(deleteId);
        if (exist) {
            menuRepository.deleteById(deleteId);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Menu ID = %s doesn't exits in db!", deleteId));

    }

    @Override
    public MenuDto findMenuByName(String name) {
        Menu IsFound = menuRepository.findMenuByName(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Menu name = %s doesn't exits in db!", name))
        );
        return menuMapper.toMenuDto(IsFound);
    }

    @Override
    public List<MenuDto> findAllMenus() {
        return menuMapper.toMenuDtoList(menuRepository.findAll());
    }

    @Override
    public MenuDto findMenuById(Integer id) {
        Menu IsFound = menuRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Menu ID = %s doesn't exits in db!", id))
        );
        return menuMapper.toMenuDto(IsFound);
    }
}
