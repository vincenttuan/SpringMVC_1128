package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.DerbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/derby")
public class DerbyController {

    @Autowired
    private DerbyService service;
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby/query/PU_VIEW
    @RequestMapping("/query/PU_VIEW")
    @ResponseBody
    public String queryPU_VIEW() {
        return new Gson().toJson(service.queryPU_VIEW());
    }
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby/get/PU_TOTAL
    @RequestMapping("/get/PU_TOTAL")
    @ResponseBody
    public String getPU_TOTAL(Model model) {
        return new Gson().toJson(service.getPU_TOTAL());
    }
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby/query/PU_TOP10
    @RequestMapping("/query/PU_TOP10")
    @ResponseBody
    public String queryPU_TOP10() {
        return new Gson().toJson(service.queryPU_TOP10());
    }
    
    @RequestMapping("/query/PU")
    public String queryP(Model model) {
        model.addAttribute("PU_TOTAL", service.getPU_TOTAL());
        model.addAttribute("PU_TOP10", service.queryPU_TOP10());
        model.addAttribute("PU_VIEW", service.queryPU_VIEW());
        return "derby_pu";
    }

}
