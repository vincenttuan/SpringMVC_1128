package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ec")
public class ECommerceController {
    @Autowired
    private ECommerceService service;
    
    @RequestMapping("/queryCustomer_json")
    @ResponseBody
    public String queryCustomer_json() {
        return new Gson().toJson(service.queryCustomer());
    }
    
    @RequestMapping("/queryCustomer")
    public String queryCustomer(Model model) {
        model.addAttribute("customers", service.queryCustomer());
        return "customers";
    }
    
}
