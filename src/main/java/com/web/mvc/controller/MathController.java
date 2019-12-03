package com.web.mvc.controller;

import com.web.mvc.beans.DIV;
import com.web.mvc.beans.MOD;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/math")
public class MathController {
    
    @RequestMapping("/add/{x}/{y}")
    public String add(@PathVariable Integer x, @PathVariable Integer y, Model model) {
        Integer sum = x + y;
        model.addAttribute("sum", sum);
        return "math_result";
    }
    
    @RequestMapping("/sub")
    public String sub(@RequestParam(name = "x", defaultValue = "0", required = false) Integer x,
                      @RequestParam(name = "y", defaultValue = "0", required = false) Integer y,
                      Model model) {
        Integer sum = x - y;
        model.addAttribute("sum", sum);
        return "math_result";
    }
    
    @RequestMapping("/mul/{x}")
    public String mul(@PathVariable Integer x,
                      @RequestParam(name = "y", defaultValue = "0", required = false) Integer y,
                      Model model) {
        Integer sum = x * y;
        model.addAttribute("sum", sum);
        return "math_result";
    }
    
    @RequestMapping(value = {"/div"}, method = {RequestMethod.POST})
    public String div(DIV div, Model model) {
        Integer sum = div.getX() / div.getY();
        div.setSum(sum);
        model.addAttribute("sum", div);
        return "math_result";
    }
    
    @RequestMapping(value = {"/mod"}, method = {RequestMethod.POST})
    public String mod(@ModelAttribute("sum") MOD mod) {
        Integer sum = mod.getX() % mod.getY();
        mod.setSum(sum);
        return "math_result";
    }
    
    
    
    
    
}
