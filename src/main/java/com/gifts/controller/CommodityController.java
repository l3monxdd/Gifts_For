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
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class CommodityController {
	@Autowired
	private CommodityService commodityService;

	@Autowired
	private MeasuringSystemService measuringSystemService;

	@GetMapping("/commodity")
	public String commodity(Model model, @PageableDefault Pageable pageable){
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));
		model.addAttribute("measuringSystems", measuringSystemService.findAll());
		return "commodity";
	}

	@PostMapping("/commodity")
	public String commodity(@RequestParam String name_of_commodity,
							@RequestParam double price_id_uan, @RequestParam int quantity,
							@RequestParam int ms, Model model, @PageableDefault Pageable pageable,
							@RequestParam MultipartFile image){
		model.addAttribute("commodities", commodityService.commodityWithMeasuringSystemPages(pageable));

		Commodity commodity = new Commodity(name_of_commodity,quantity,price_id_uan);

		System.out.println("commodity = " + commodity);

		try {
			commodityService.save(commodity, ms, image);
		}catch (Exception e){
			if (e.getMessage().equals(CommodityValidatorMessages.EMPTY_NAME_OF_COMMODITY_FIELD) ||
					e.getMessage().equals(CommodityValidatorMessages.NAME_OF_COMMODITY_ALREADY_EXIST)){
				model.addAttribute("commodityNameException", e.getMessage());
			}

			model.addAttribute("measuringSystems", measuringSystemService.findAll());
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
		model.addAttribute("measuringSystems", measuringSystemService.findAll());

		return "updateCommodity";
	}



	@PostMapping("/updateCommodity/{id}")
	public String updateCommodity(@PathVariable int id,
								  @RequestParam String name_of_commodity,
								  @RequestParam int quantity,
								  @RequestParam double price_id_uan,
								  @RequestParam MultipartFile image,
								  @RequestParam int ms){


		Commodity commodity = commodityService.findCommoditiesWithMeasuringSystem(id);
		commodity.setName_of_commodity(name_of_commodity);
		commodity.setQuantity(quantity);
		commodity.setPrice_id_uan(price_id_uan);

		commodityService.update(commodity, image, ms);

		return "redirect:/commodity";
	}


	@GetMapping("/show")
	public String show(Model model
	){
		model.addAttribute("commodities",  commodityService.findAll());
		return "commodity";
	}

}
