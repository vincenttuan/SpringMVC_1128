package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.LottoService;
import com.web.mvc.service.LottoServiceImpl;
import com.web.mvc.service.WeatherService;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @RequestMapping("/weather")
    public String weather(@RequestParam(name = "cityName", defaultValue = "Taoyuan", required = false) String cityName, Model model) {
        try {
            model.addAttribute("weather", weatherService.find(cityName));
        } catch (Exception e) {
        }
        return "weather";
    }
    
}
