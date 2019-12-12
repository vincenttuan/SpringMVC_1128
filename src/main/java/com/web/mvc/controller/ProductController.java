package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.beans.Product;
import com.web.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/input")
    public String input(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("groups", ProductService.groups.values());
        model.addAttribute("action", "save");
        model.addAttribute("products", ProductService.products);
        return "product";
    }
    
    @RequestMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
        productService.save(product);
        return "redirect:/mvc/product/input";
    }

    @RequestMapping("/get/{name}")
    public String get(@PathVariable("name") String name, Model model) {
        Product product = productService.get(name);
        model.addAttribute("product", product);
        model.addAttribute("groups", ProductService.groups.values());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        model.addAttribute("products", ProductService.products);
        return "product";
    }
    
    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/mvc/product/input";
    }
    
    @RequestMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name) {
        productService.delete(name);
        return "redirect:/mvc/product/input";
    }
    
    @RequestMapping("/query")
    @ResponseBody
    public String query() {
        String json = "";
        json = new Gson().toJson(productService.query());
        return json; // 請以 json 格式顯示資料
    }

    
}
