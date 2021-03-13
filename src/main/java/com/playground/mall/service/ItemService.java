package com.playground.mall.service;

import com.playground.mall.entity.Item;
import com.playground.mall.model.request.ItemRequest;
import com.playground.mall.repository.ItemRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Long itemId, ItemRequest request) {
        itemRepository.findById(itemId).ifPresent(m -> m.modify(request.getPrice(), request.getStockQuantity()));
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findItem(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
}
