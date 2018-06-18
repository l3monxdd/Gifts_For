package com.gifts.controller;

import com.gifts.validator.AddressValidator.AddressValidatorMessages;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.Address;
import com.gifts.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;


	@GetMapping("/address")
	public String address(Model model) {

		for (Address address : addressService.findAll()) {
			System.out.println("address = " + address.getStreet());
		}


		model.addAttribute("addresses", addressService.findAll());
		model.addAttribute("address", new Address() );
		return "address";
	}

	@PostMapping("/address")
	public String address(@ModelAttribute Address address, Model model) {
		try {
			addressService.save(address);
		}catch (Exception e){
			if (e.getMessage().equals(AddressValidatorMessages.EMPTY_STREET_FIELD) ||
					e.getMessage().equals(AddressValidatorMessages.STREET_ALREADY_EXIST)){

				model.addAttribute("streetException", e.getMessage());
			}

			return "address";
		}

		return "redirect:/address";

	}

	@GetMapping("/deleteAddress/{id}")
	public String deleteaddress(@PathVariable int id) {
		addressService.delete(id);

		return "redirect:/address";

	}

}
