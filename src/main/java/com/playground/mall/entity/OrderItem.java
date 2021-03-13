package com.playground.mall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

    // 생성 메소드
    public OrderItem(Item item, int orderPrice, int count) {
        this.setItem(item);
        this.setOrderPrice(orderPrice);
        this.setCount(count);

        item.removeStock(count);
    }

    // 주문취소
    public void cancel() {
        getItem().addStock(count);
    }

    // 주문상품 전체 가격 조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
