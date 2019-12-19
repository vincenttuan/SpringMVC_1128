package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/queryPurchaseOrder_json/{customerId}")
    @ResponseBody
    public String queryPurchaseOrder_json(@PathVariable int customerId) {
        return new Gson().toJson(service.queryPurchaseOrder(customerId));
    }

    @RequestMapping("/queryPurchaseOrder/{customerId}")
    public String queryPurchaseOrder(@PathVariable int customerId, Model model) {
        model.addAttribute("purchaseOrders", service.queryPurchaseOrder(customerId));
        return "purchase_order";
    }

    @RequestMapping("/queryPurchaseOrder")
    public String queryPurchaseOrder(Model model) {
        model.addAttribute("purchaseOrders", service.queryPurchaseOrder());
        return "purchase_order";
    }

}
