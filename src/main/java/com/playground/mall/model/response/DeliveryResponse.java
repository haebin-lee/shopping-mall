package com.playground.mall.model.response;

import com.playground.mall.entity.Address;
import com.playground.mall.entity.Delivery;
import com.playground.mall.model.DeliveryStatus;
import lombok.Getter;

@Getter
public class DeliveryResponse {

    private Long id;
    private Address address;
    private DeliveryStatus status;

    public DeliveryResponse(Delivery delivery) {
        this.id = delivery.getId();
        this.address = delivery.getAddress();
        this.status = delivery.getStatus();
    }
}
