package com.playground.mall.model.request;

import com.playground.mall.entity.Item;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ItemRequest {

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @NotNull
    private int stockQuantity;

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }
}
