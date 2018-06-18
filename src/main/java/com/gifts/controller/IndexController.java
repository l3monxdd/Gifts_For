package com.gifts.controller;

import com.gifts.service.CommodityService;
import com.gifts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class IndexController {
	@Autowired
	private CommodityService commodityService;

	@Autowired
	private UserService userService;


	@GetMapping("/")
	public String index(Model model, @PageableDefault Pageable pageable, Principal principal) {
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));

		if(!(principal == null || principal.getName().equals("admin"))){
			model.addAttribute("uniquser", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));
		}

		return "views-base-index";
	}


	@PostMapping("/")
	public String indexAfterLogin(Model model, @PageableDefault Pageable pageable, @RequestParam String username) {
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));


		if(!(username.equals("admin"))){
			model.addAttribute("uniquser", userService.findUserByLoginWithCommodities(username));
		}



		return "views-base-index";
	}

	@GetMapping("/login")
	public String login (){
		return "views-base-index";
	}
}
