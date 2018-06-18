package com.gifts.controller;

import com.gifts.entity.Orders;
import com.gifts.service.CommodityService;
import com.gifts.service.OrdersService;
import com.gifts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dell on 06.07.17.
 */

@Controller
public class AllOrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;


    @GetMapping("/allOrders")
    public String allOrders(Model model){
//        model.addAttribute("orders", ordersService.ordersWithCommodities());
        model.addAttribute("orders", ordersService.ordersWithCommodityCouters());



        return "views-admin-allOrders";

    }

    @PostMapping("/allOrders")
    public String allOrders(@RequestParam List<Boolean> done){

        ordersService.orderIsDone(done);

        return "redirect:/";
    }
}
