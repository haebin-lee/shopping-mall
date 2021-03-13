package com.playground.mall.model.response;

import com.playground.mall.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponse {

    private String name;

    private int price;

    private int stockQuantity;

    public ItemResponse(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.stockQuantity = item.getStockQuantity();
    }
}
