package com.codility.ing;
 

import com.codility.external.Item1;
import com.codility.external.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class UsersService {

	@Autowired
	private OrdersService ordersService;

	public int getNumberOfItemsBought(Long username) {
		//ordersService.findAll(username)
		return 1;
	}

	public Item1 create(Item1 item) {
		 
		return ordersService.create(item);
	}
}
