package com.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.order.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

}
