package com.playground.mall.repository;

import com.playground.mall.entity.Order;
import com.playground.mall.entity.QMember;
import com.playground.mall.entity.QOrder;
import com.playground.mall.model.OrderSearchRequest;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements OrderRepositoryCustom{

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> search(OrderSearchRequest request) {

        QOrder order = QOrder.order;
        QMember member = QMember.member;

        JPQLQuery query = from(order);

        if (StringUtils.hasText(request.getMemberName())) {
            query.leftJoin(order.member(), member)
                    .where(member.name.contains(request.getMemberName()));
        }

        if (request.getOrderStatus() != null) {
            query.where(order.status.eq(request.getOrderStatus()));
        }
        return query.fetch();
    }
}
