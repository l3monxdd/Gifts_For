package com.gifts.controller;

import com.gifts.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	@Autowired
	private CommodityService commodityService;


	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("commodities", commodityService.commoditywithMeasuringSystem());
		return "index";
	}


	@PostMapping("/")
	public String indexAfterLogin() {
		return "index";
	}
}
