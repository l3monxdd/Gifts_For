package com.gifts.controller;

import com.gifts.service.OrdersService;
import com.gifts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Created by dell on 09.06.17.
 */
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @GetMapping("/addIntoBasket/{id}")
    public String addIntoBasket( Principal principal, @PathVariable int id){


        ordersService.addIntoBasket(principal, id);


        return "redirect:/";

    }

    @GetMapping("/deleteFromBasket/{userId}/{commodityId}")
    public String deleteFromBasket(@PathVariable int userId, @PathVariable int commodityId){
        ordersService.deleteFromBasket(userId, commodityId);

        return "redirect:/profile";
    }
//
    @PostMapping("/buy/{userId}")
    public String buy (@PathVariable int userId){

        ordersService.buy(userId);

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
