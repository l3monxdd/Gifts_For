package com.gifts.controller;

import com.gifts.service.MeasuringSystemService;
import com.gifts.validator.CommodityValidator.CommodityValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.Commodity;
import com.gifts.service.CommodityService;

import java.security.Principal;

@Controller
public class CommodityController {
	@Autowired
	private CommodityService commodityService;

	@Autowired
	private MeasuringSystemService measuringSystemService;

	@GetMapping("/commodity")
	public String commodity(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("commodities", commodityService.commoditywithMeasuringSystem());
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));
		model.addAttribute("measuringSystems", measuringSystemService.findAll());
		model.addAttribute("commodity", new Commodity());
		return "commodity";
	}


//	@GetMapping("/commodity")
//	public String commodity(Model model, Principal principal, @PageableDefault Pageable pageable) {
//		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));
//			return "/commodity";
//	}



	@PostMapping("/commodity")
	public String commodity(@ModelAttribute Commodity commodity,
							@RequestParam int ms, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));
		try {
			commodityService.save(commodity, ms);
		}catch (Exception e){
			if (e.getMessage().equals(CommodityValidatorMessages.EMPTY_NAME_OF_COMMODITY_FIELD) ||
					e.getMessage().equals(CommodityValidatorMessages.NAME_OF_COMMODITY_ALREADY_EXIST)){
				model.addAttribute("commodityNameException", e.getMessage());
			}
			return "commodity";
		}



		return "redirect:/commodity";
	}





	@GetMapping("/deleteCommodity/{id}")
	public String deleteCommodity(@PathVariable int id){

		commodityService.delete(id);

		return "redirect:/commodity";
	}

	@GetMapping("/updateCommodity/{id}")
	public  String updateCommodity(@PathVariable int id, Model model){

		Commodity commodity =
				commodityService.findCommoditiesWithMeasuringSystem(id);


		model.addAttribute("commodity",commodity);

		return "updateCommodity";
	}

	@GetMapping("/show")
	public String show(Model model
	){
		model.addAttribute("commodities",  commodityService.findAll());
		return "commodity";
	}

}
