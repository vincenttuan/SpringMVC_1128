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

    @RequestMapping("/query/PU_VIEW")
    @ResponseBody
    public String queryPU_VIEW() {
        return new Gson().toJson(service.queryPU_VIEW());
    }

    @RequestMapping("/get/PU_TOTAL")
    @ResponseBody
    public String getPU_TOTAL(Model model) {
        return new Gson().toJson(service.getPU_TOTAL());
    }

    @RequestMapping("/query/TOP10")
    @ResponseBody
    public String queryPU_TOP10() {
        return new Gson().toJson(service.queryPU_TOP10());
    }

}
