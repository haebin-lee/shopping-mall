package com.playground.mall.controller;

import com.playground.mall.entity.Item;
import com.playground.mall.model.request.ItemRequest;
import com.playground.mall.model.response.ItemResponse;
import com.playground.mall.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemResponse>> findItems() {
        List<Item> items = itemService.findItems();
        return ResponseEntity.ok(items.stream().map(ItemResponse::new).collect(Collectors.toList()));
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<ItemResponse> findItem(
            @PathVariable Long itemId
    ) {
        Item item = itemService.findItem(itemId);
        return ResponseEntity.ok(new ItemResponse(item));
    }

    @PostMapping("/item")
    public ResponseEntity<Void> createItem(@RequestBody ItemRequest request) {
        itemService.saveItem(request.toEntity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/item/{itemId}")
    public ResponseEntity<Void> updateItem(
            @PathVariable Long itemId,
            @RequestBody ItemRequest request) {
        itemService.updateItem(itemId, request);
        return ResponseEntity.ok().build();
    }


}
