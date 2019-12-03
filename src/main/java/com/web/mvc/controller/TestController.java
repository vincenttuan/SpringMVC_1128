package com.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class TestController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // ...
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "John"); // 相當於 request.setAttribute("name")
        return mv;
    }
    
}
