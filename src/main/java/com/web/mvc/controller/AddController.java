package com.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AddController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int x = 0, y = 0, result = 0;
        try {
            x = Integer.valueOf(req.getParameter("x"));
            y = Integer.valueOf(req.getParameter("y"));
            result = x + y;
        } catch (Exception e) {
        }
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("x", x);
        mv.addObject("y", y);
        mv.addObject("result", result);
        return mv;
    }
    
}
