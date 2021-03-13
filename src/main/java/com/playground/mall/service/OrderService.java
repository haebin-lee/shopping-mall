package com.playground.mall.service;

import com.playground.mall.entity.*;
import com.playground.mall.model.OrderSearchRequest;
import com.playground.mall.repository.MemberRepository;
import com.playground.mall.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    // 주문
    public Long order(Long memberId, Long itemId, int count) {
        // 엔티티 조회
        Member member = memberRepository.findById(memberId).orElse(null);
        Item item = itemService.findItem(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = new OrderItem(item, item.getPrice(), count);

        // 주문생성
        Order order = new Order(member, delivery, orderItem);

        // 주문저장
        orderRepository.save(order);
        return order.getId();
    }

    // 주문 취소
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElse(null);

        // 주문 취소
        order.cancel();
    }

    // 주문 검색
    public List<Order> findOrders(OrderSearchRequest request) {
        return orderRepository.findAll(request.toSpecification());
    }
}
