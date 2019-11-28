package com.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AddController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int result = 0;
        try {
            int x = Integer.valueOf(req.getParameter("x"));
            int y = Integer.valueOf(req.getParameter("y"));
            result = x + y;
        } catch (Exception e) {
        }
        ModelAndView mv = new ModelAndView("/WEB-INF/jsp/result.jsp");
        mv.addObject("result", result);
        return mv;
    }
    
}
