package com.playground.mall.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    private Long orderId;

    private Long itemId;

    private int orderPrice;

    private int count;
}
