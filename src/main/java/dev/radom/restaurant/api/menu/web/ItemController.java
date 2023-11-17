package dev.radom.restaurant.api.menu.web;

import dev.radom.restaurant.api.menu.ItemService;
import dev.radom.restaurant.utils.UpdateStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
@RestController
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    List<ItemDto> getAllItems() {
        return itemService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createNewItem(@RequestBody @Valid AddItemDto addItemDto) {
        itemService.createItem(addItemDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{uuid}")
    void updateIsPresentByUuid(@PathVariable String uuid,
                               @RequestBody UpdateStatus updateStatus) {
        itemService.UpdateIsPresentByUuid(uuid, updateStatus.status());
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{uuid}")
    void updateItemByUuid(@PathVariable String uuid,
                          @RequestBody UpdateItemDto updateItemDto) {
        itemService.updateItemByUuid(uuid, updateItemDto);
    }

    @DeleteMapping("/{uuid}")
    void deleteItemByUuid(@PathVariable String uuid) {
        itemService.deleteItemByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    ItemDto findItemByUuid(@PathVariable String uuid) {
        return itemService.findItemByUuid(uuid);
    }

}
