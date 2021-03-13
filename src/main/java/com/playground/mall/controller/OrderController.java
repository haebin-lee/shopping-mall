package com.playground.mall.controller;

import com.playground.mall.entity.Order;
import com.playground.mall.model.OrderSearchRequest;
import com.playground.mall.model.OrderStatus;
import com.playground.mall.model.response.OrderResponse;
import com.playground.mall.service.ItemService;
import com.playground.mall.service.MemberService;
import com.playground.mall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @PostMapping("/order/search")
    public ResponseEntity<List<OrderResponse>> searchOrders(
            @RequestBody OrderSearchRequest request
    ) {
        List<Order> orders = orderService.findOrders(request);
        return ResponseEntity.ok(orders.stream().map(OrderResponse::new).collect(Collectors.toList()));
    }

    @PostMapping("/order")
    public ResponseEntity<Void> doOrder(
            @RequestParam("memberId") Long memberId,
            @RequestParam("itemId") Long itemId,
            @RequestParam("count") int count
    ) {
        orderService.order(memberId, itemId, count);
        return ResponseEntity.ok().build();
    }
}
