package com.web.mvc.controller;

import com.web.mvc.beans.BMI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BMIController {
    
    @RequestMapping("/bmi")
    public ModelAndView calcBMI(HttpServletRequest req) {
        double h = Double.parseDouble(req.getParameter("h"));
        double w = Double.parseDouble(req.getParameter("w"));
        BMI bmi = new BMI(h, w);
        ModelAndView mv = new ModelAndView("bmi_result");
        mv.addObject("bmi", bmi);
        return mv;
    }
}
