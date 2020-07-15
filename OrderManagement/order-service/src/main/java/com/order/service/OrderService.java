package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.order.ItemServiceProxy;
import com.order.exception.OrderNotFound;
import com.order.model.Item;
import com.order.model.Orders;
import com.order.repository.OrderRepository;

import feign.FeignException;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemServiceProxy proxy;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	public Orders createOrder(Orders order) throws OrderNotFound, FeignException {
		Set<Item> items = order.getOrderItems().stream().map(inputOrder -> proxy.getItem(inputOrder.getProductCode()))
				.collect(Collectors.toSet());

		Set<Item> updateditems = order.getOrderItems().stream().filter(
				inputOrder -> items.stream().anyMatch(action -> action.getQuantity() > inputOrder.getQuantity()))
				.map(inputOrder -> proxy.updateItem(inputOrder)).collect(Collectors.toSet());

		if (CollectionUtils.isEmpty(updateditems)) {
			logger.error("Quatity of items not available for the order {} ", order.getOrderId());
			throw new OrderNotFound("Quatity of items not available for the order : " + order.getOrderId());
		}

		Orders savedOrder = orderRepository.save(order);
		return savedOrder;
	}

	public Orders getOrder(Long orderId) {
		Optional<Orders> order = orderRepository.findById(orderId);
		if (!order.isPresent()) {
			logger.error("Quatity of items not available for the order {} ", orderId);
			throw new OrderNotFound("Quatity of items not available for the order : " + orderId);
		}
		return order.get();
	}
	
	public List<Orders> getAllOrders() {
		Iterable<Orders> orderList = orderRepository.findAll();
		List<Orders> orders = new ArrayList<>();
		if (Objects.isNull(orderList)) {
			logger.error("No ordered items found for the user : ");
			throw new OrderNotFound("No ordered items found for the user : ");
		}
		for (Orders order : orderList) {
			orders.add(order);
		}
		return orders;
	}

}
