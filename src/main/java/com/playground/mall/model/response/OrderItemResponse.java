package com.playground.mall.model.response;

import com.playground.mall.entity.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemResponse {

    private Long id;
    private int orderPrice;
    private int count;

    public OrderItemResponse(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.orderPrice = orderItem.getOrderPrice();
        this.count = orderItem.getCount();
    }
}
