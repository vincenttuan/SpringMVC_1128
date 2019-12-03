package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/math")
public class MathController {
    @RequestMapping("/add/{x}/{y}")
    public String add(@PathVariable Integer x, @PathVariable Integer y, Model model) {
        Integer sum = x + y;
        model.addAttribute("sum", sum);
        return "math_result";
    }
}
