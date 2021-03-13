package com.playground.mall.model;

import lombok.Getter;

@Getter
public class OrderSearchRequest {

    private String memberName;
    private OrderStatus orderStatus;
}
