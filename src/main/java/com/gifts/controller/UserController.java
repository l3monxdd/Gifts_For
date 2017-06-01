package com.gifts.controller;

import com.gifts.validator.UserValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.User;
import com.gifts.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute User user, Model model) {
		try {
			userService.save(user);
		} catch (Exception e){
			if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
					e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)){

				model.addAttribute("loginException", e.getMessage());
			}else if (e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST)){

				model.addAttribute("emailException", e.getMessage());
			}

			return "registration";
		}

		return "redirect:/registration";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteuser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/registration";
	}

}
