package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.LottoService;
import com.web.mvc.service.LottoServiceImpl;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/lotto")
public class LottoController {
    
    @Autowired
    private LottoService lottoService;
    
    @RequestMapping("/539")
    @ResponseBody
    public String lotto539(@RequestParam(name = "count", defaultValue = "1", required = false) Integer count) {
        return new Gson().toJson(lottoService.lotto539(count));
    }
    
    @RequestMapping("/4star")
    @ResponseBody
    public String lotto4star(@RequestParam(name = "count", defaultValue = "1", required = false) Integer count) {
        return new Gson().toJson(lottoService.lotto4Star(count));
    }
    
    @RequestMapping("/3star")
    @ResponseBody
    public String lotto3star(@RequestParam(name = "count", defaultValue = "1", required = false) Integer count) {
        return new Gson().toJson(lottoService.lotto3Star(count));
    }
}
