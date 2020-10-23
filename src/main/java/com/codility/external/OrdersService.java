package com.codility.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	private OrderRepository orderRepository;
	public Item1 create(Item1 item) {
		return orderRepository.save(item);
	}
	
	public Item1 findAll(Long username) {
		return orderRepository.findById(username).get();
	}
	
	
}
