package com.gifts.controller;

import com.gifts.validator.SuitOfDeliveryValidator.SuitOfDeliveryValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.SuitOfDelivery;
import com.gifts.service.SuitOfDeliveryService;

@Controller
public class SuitofdeliveryController {

	// використання спрінг форм
	@Autowired
	private SuitOfDeliveryService suitOfDeliveryService;

	@GetMapping("/suitofdelivery")
	public String suitofdelivery(Model model) {

		model.addAttribute("suitofdeliveries", suitOfDeliveryService.findAll());

//		model.addAttribute("suitofdelivery", new SuitOfDelivery());

		return "suitofdelivery";
	}

	@PostMapping("/suitofdelivery")
	public String suitofdelivery(@RequestParam String name, Model model) {

		try {
			suitOfDeliveryService.save(new SuitOfDelivery(name));
		}catch (Exception e){
			if (e.getMessage().equals(SuitOfDeliveryValidatorMessages.EMPTY_NAME_FIELD) ||
					e.getMessage().equals(SuitOfDeliveryValidatorMessages.SUIT_ALREADY_EXIST)){

				model.addAttribute("suitException", e.getMessage());
			}
			return "suitofdelivery";
		}

		return "redirect:/suitofdelivery";
	}



	@GetMapping("/deleteSuitOfDelivery/{id}")
	public String deleteSuitOfDelivery(@PathVariable int id){
		suitOfDeliveryService.delete(id);


		return "redirect:/suitofdelivery";
	}

}
