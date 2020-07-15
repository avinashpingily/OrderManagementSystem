package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.exception.OrderNotFound;
import com.order.model.Orders;
import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order/create")
	public @ResponseBody Orders createOrder(@Valid @RequestBody Orders order) throws OrderNotFound{
		Orders savedOrder = orderService.createOrder(order);
		return savedOrder;
	}
	
	@GetMapping("/order/{orderId}")
	public @ResponseBody Orders getOrders(@PathVariable Long orderId) {
		Orders Order = orderService.getOrder(orderId);
		return Order;
	}
	
	@GetMapping("/order")
	public List<Orders> getAllOrders() {
		List<Orders> orders = orderService.getAllOrders();
		return orders;
	}
	
}
