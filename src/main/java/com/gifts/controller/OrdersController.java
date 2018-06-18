package com.gifts.controller;

import com.gifts.entity.Address;
import com.gifts.entity.Commodity;
import com.gifts.entity.User;
import com.gifts.service.*;
import com.gifts.validator.CommodityValidator.CommodityValidatorMessages;
import com.gifts.validator.ProfileValidator.ProfileException;
import com.gifts.validator.ProfileValidator.ProfileValidatorMessages;
import com.gifts.validator.UserValidator.UserException;
import com.gifts.validator.UserValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 09.06.17.
 */
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private SuitOfDeliveryService suitOfDeliveryService;

    @Autowired
    private CommodityService commodityService;


    @GetMapping("/addIntoBasket/{id}")
    public String addIntoBasket(Principal principal, @PathVariable int id) {


        ordersService.addIntoBasket(principal, id);


        return "redirect:/";

    }

    @GetMapping("/deleteFromBasket/{userId}/{commodityId}")
    public String deleteFromBasket(@PathVariable int userId, @PathVariable int commodityId) {
        ordersService.deleteFromBasket(userId, commodityId);

        return "redirect:/profile";
    }


    @GetMapping("/buy/{userId}")
    public String buy(Model model, @PathVariable int userId, @RequestParam List<Integer> counters,
                      @RequestParam String street,
                      @RequestParam String number_of_build,
                      @RequestParam String number_of_apartament,
                      @RequestParam String town, @RequestParam int suit,
                      @RequestParam String description) {


        if (number_of_apartament.replaceAll("[^0-9]", "").isEmpty()) {

        } else {
            Integer.parseInt(number_of_apartament);
        }

        try {
            Address address = new Address(street, number_of_build, number_of_apartament, town);
            ordersService.buy(userId, address, suit, description, counters);
        } catch (Exception e) {
            model.addAttribute("testuser", userService.findOne(userId));
            model.addAttribute("user", userService.findUserWithCommodity(userId));
            model.addAttribute("suit_of_delivery", suitOfDeliveryService.findAll());
            model.addAttribute("commodities", commodityService.findAll());

            System.out.println("e = " + e);

//
            if (e.getMessage().equals(ProfileValidatorMessages.STREET_FIELD_IS_EMPTY)) {
                model.addAttribute("streetException", e.getMessage());
            } else if (e.getMessage().equals(ProfileValidatorMessages.EMPTY_NUMBER_OF_BUILD_FIELD)){
                model.addAttribute("numberOfBuildException", e.getMessage());
            }else if (e.getMessage().equals(ProfileValidatorMessages.EMPTY_NUMBER_OF_APA_FIELD)){
                model.addAttribute("numberOfApartamentException", e.getMessage());
            }else if(e.getMessage().equals(ProfileValidatorMessages.EMPTY_TOWN_FIELD)){
                model.addAttribute("emptyTownException", e.getMessage());
            }else if(e.getMessage().equals(ProfileValidatorMessages.TOWN_CONTAIN_NUMBERS)){
                model.addAttribute("containNumber", e.getMessage());
            }
            else {
                model.addAttribute("counterException", e.getMessage());
            }

            return "views-user-profile";
        }

        return "redirect:/profile";
    }
//    @PostMapping("/buy")
//    public String buy(Principal principal){
//
//        ordersService.buy(Integer.parseInt(principal.getName()));
//
//        return "redirect:/profile";
//
//    }

}
