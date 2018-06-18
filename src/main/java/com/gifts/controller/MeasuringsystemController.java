package com.gifts.controller;

import com.gifts.validator.MeasuringSystemValidator.MeasuringSystemValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.MeasuringSystem;
import com.gifts.service.MeasuringSystemService;

@Controller
public class MeasuringsystemController {

	@Autowired
	private MeasuringSystemService measuringSystemService;

	@GetMapping("/measuringsystem")
	public String measuringsystem(Model model) {
		model.addAttribute("measuringsystems", measuringSystemService.findAll());
		model.addAttribute("measuringSystem", new MeasuringSystem());
		return "views-admin-measuringsystem";
	}

//	@PostMapping("/measuringsystem")
//	public String measuringsystem(@RequestParam String name) {
//		measuringSystemService.save(new MeasuringSystem(name));
//		return "redirect:/measuringsystem";
//	}

	@PostMapping("/measuringsystem")
	public String measuringsystem(@ModelAttribute MeasuringSystem measuringSystem, Model model) {
		try {
			measuringSystemService.save(measuringSystem);
		}catch (Exception e){
			if (e.getMessage().equals(MeasuringSystemValidatorMessages.EMPTY_NAME_FIELD) ||
					e.getMessage().equals(MeasuringSystemValidatorMessages.MEASURING_SYSTEM_ALREADY_EXIST)){

				model.addAttribute("measuringSystemException", e.getMessage());
			}

			return "views-admin-measuringsystem";

		}

		return "redirect:/measuringsystem";
	}

	@GetMapping("/deleteMeasuringSystem/{id}")
	public String deleteMeasuringSystem(@PathVariable int id){
		measuringSystemService.delete(id);
		return "redirect:/measuringsystem";
	}

	@GetMapping("/updateMeasuringSystem/{id}")
	public String updateMeasuringSystem(@PathVariable int id, Model model){
		MeasuringSystem measuringSystem = measuringSystemService.findOne(id);

		model.addAttribute("currentMeasuringSystem", measuringSystem);

		return "views-admin-updateMeasuringSystem";
	}

	@PostMapping("/updateMeasuringSystem/{id}")
	public String updateMeasuringSystem(@RequestParam String name, @PathVariable int id){

		MeasuringSystem measuringSystem = measuringSystemService.findOne(id);

		measuringSystem.setName(name);

		measuringSystemService.update(measuringSystem);

		return "redirect:/measuringsystem";
	}

}
