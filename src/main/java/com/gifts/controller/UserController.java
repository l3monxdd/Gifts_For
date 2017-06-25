package com.gifts.controller;

import com.gifts.service.MailSenderService;
import com.gifts.service.SuitOfDeliveryService;
import com.gifts.validator.UserValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gifts.entity.User;
import com.gifts.service.UserService;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailSenderService mailSenderService;

	@Autowired
	private SuitOfDeliveryService suitOfDeliveryService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute User user, Model model) {

//		System.out.println("user = " + user);

		String uuid = UUID.randomUUID().toString();

		user.setUuid(uuid);

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

		String theme = "thank's for registration";
		String mailBody =
				"gl & hf       http://localhost:8080/confirm/" + uuid;

		mailSenderService.sendMail(theme, mailBody, user.getEmail());

		return "redirect:/registration";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteuser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/registration";
	}

	@PostMapping("/logout")
	public String logout(){
		return "redirect:/";
	}

	@GetMapping("/profile")
	public String profile(Principal principal, Model model){
		model.addAttribute("user", userService.findUserWithCommodity(Integer.parseInt(principal.getName())));
		model.addAttribute("suit_of_delivery", suitOfDeliveryService.findAll());
		return "profile";
	}

//	@GetMapping("/buy/{id}")
//	public  String like (Principal principal, @PathVariable int id){
//
//
////		userService.like(principal, id);
//
//		return "redirect:/";
//	}

	@GetMapping("/confirm/{uuid}")
	public String confirm(@PathVariable String uuid) {

		User user = userService.findByUuid(uuid);
		user.setEnable(true);

		userService.update(user);

		return "redirect:/";
	}

}
