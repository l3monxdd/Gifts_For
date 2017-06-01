package com.gifts.controller;

import java.time.LocalDate;

import com.gifts.editors.UserEditor;
import com.gifts.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.Orders;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}




	@GetMapping("/orders")
	public String order(Model model	) {

		model.addAttribute("orders", ordersService.findAll());
		model.addAttribute( "users", userService.findAll());
		;
		model.addAttribute("order", new Orders());


		return "orders";
	}

	@PostMapping("/orders")
	public String order(@ModelAttribute Orders orders) {
		ordersService.save(orders);
		return "redirect:/orders";
	}

}
