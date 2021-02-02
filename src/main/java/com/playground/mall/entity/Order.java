package com.playground.mall.entity;

import com.playground.mall.model.OrderStatus;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Table(name = "ORDERS")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
