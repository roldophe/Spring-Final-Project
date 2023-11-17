package dev.radom.restaurant.api.menu;

import dev.radom.restaurant.api.menu.web.AddItemDto;
import dev.radom.restaurant.api.menu.web.ItemDto;
import dev.radom.restaurant.api.menu.web.UpdateItemDto;
import dev.radom.restaurant.utils.RandomCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final MenuRepository menuRepository;
    private final ItemMapper itemMapper;

    @Override
    @Transactional
    public void createItem(AddItemDto addItemDto) {
        boolean exists = menuRepository.existsById(addItemDto.menuId());
        Optional<Item> itemOptional = itemRepository.findItemByName(addItemDto.name());
        if (itemOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("name %s already exist!", addItemDto.name()));
        }
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("menu id = %s  does not exits in db!", addItemDto.menuId()));
        }
        Item item = itemMapper.fromCreateItemDto(addItemDto);
        item.setUuid(UUID.randomUUID().toString());
        item.setCode("ITEM-" + RandomCode.generateCode());
        item.setStatus(true);
        System.out.println(item);
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void UpdateIsPresentByUuid(String uuid, Boolean status) {
        Item isFound = itemRepository.findItemByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Item UUID = %s doesn't exits in db!", uuid))
                );
        isFound.setStatus(status);
        itemRepository.save(isFound);
    }

    @Override
    public List<ItemDto> findAll() {
        //List<Item> items = itemRepository.findAll();
        return itemMapper.toItemDtoList(itemRepository.findAll());
    }

    @Override
    public List<ItemDto> findByMenuId(Integer menuId) {
        return itemMapper.toItemDtoList(itemRepository.findByMenuId(menuId));
    }

    @Override
    public ItemDto findItemByUuid(String uuid) {
        Item isFound = itemRepository.findItemByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Item UUID = %s doesn't exits in db!", uuid))
                );
        return itemMapper.toItemDto(isFound);
    }

    @Override
    public void deleteItemByUuid(String uuid) {
        Item isFound = itemRepository.findItemByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Item UUID = %s doesn't exits in db!", uuid))
                );
        itemRepository.delete(isFound);
    }

    @Override
    public void updateItemByUuid(String uuid, UpdateItemDto updateItemDto) {
        Item isFound = itemRepository.findItemByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("User UUID = %s doesn't exits in db!", uuid))
                );
        itemMapper.fromUpdateItemDto(isFound, updateItemDto);
        itemRepository.save(isFound);
    }
}
