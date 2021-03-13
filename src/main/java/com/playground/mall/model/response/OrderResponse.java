package com.playground.mall.model.response;

import com.playground.mall.entity.Delivery;
import com.playground.mall.entity.Member;
import com.playground.mall.entity.Order;
import com.playground.mall.model.OrderStatus;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResponse {

    private Long id;
    private Member member;
    private List<OrderItemResponse> orderItems;
    private DeliveryResponse delivery;
    private Date orderDate;
    private OrderStatus status;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.member = order.getMember();
        this.orderItems = order.getOrderItems().stream()
                .map(OrderItemResponse::new)
                .collect(Collectors.toList());
        this.delivery = new DeliveryResponse(order.getDelivery());
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
    }
}
