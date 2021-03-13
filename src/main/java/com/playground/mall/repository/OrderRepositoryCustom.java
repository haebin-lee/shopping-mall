package com.playground.mall.repository;

import com.playground.mall.entity.Order;
import com.playground.mall.model.OrderSearchRequest;

import java.util.List;

public interface OrderRepositoryCustom {

    List<Order> search(OrderSearchRequest request);
}
