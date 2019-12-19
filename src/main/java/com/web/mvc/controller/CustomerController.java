package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cus")
public class CustomerController {
    @Autowired
    private CustomerService service;
    
    @RequestMapping("/queryCustomer")
    @ResponseBody
    public String queryCustomer() {
        return new Gson().toJson(service.queryCustomer());
    }
}
