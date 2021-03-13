package com.playground.mall.repository;

import com.playground.mall.entity.Order;
import com.playground.mall.model.OrderSearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
