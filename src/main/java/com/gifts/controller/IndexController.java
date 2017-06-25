package com.gifts.controller;

import com.gifts.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	@Autowired
	private CommodityService commodityService;


	@GetMapping("/")
	public String index(Model model, @PageableDefault Pageable pageable) {

		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));
		return "views-base-index";
	}


	@PostMapping("/")
	public String indexAfterLogin(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));

		return "views-base-index";
	}
}
