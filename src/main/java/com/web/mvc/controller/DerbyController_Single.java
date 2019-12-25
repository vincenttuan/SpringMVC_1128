package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.service.DerbyService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/derby_test")
public class DerbyController_Single {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby_test/append/?code=S&rate=20
    @RequestMapping("/query")
    @ResponseBody
    public String query() {
        String sql = "SELECT * FROM APP.DISCOUNT_CODE";
        return new Gson().toJson(jdbcTemplate.queryForList(sql));
    }
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby_test/append/?code=S&rate=20
    @RequestMapping("/append")
    @ResponseBody
    public int append(@RequestParam Map<String, Object> params) {
        int rowcount = jdbcTemplate.update("INSERT INTO APP.DISCOUNT_CODE(DISCOUNT_CODE, RATE) VALUES (?, ?)", 
                params.get("code"), params.get("rate"));
        return rowcount;
    }
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby_test/update/S/?rate=30
    @RequestMapping("/update/{code}")
    @ResponseBody
    public int update(@PathVariable String code, @RequestParam Map<String, Object> params) {
        int rowcount = jdbcTemplate.update("UPDATE APP.DISCOUNT_CODE SET RATE=? WHERE DISCOUNT_CODE=?", 
                params.get("rate"), code);
        return rowcount;
    }
    
    // http://localhost:8080/SpringMVC_1128/mvc/derby_test/delete/S/
    @RequestMapping("/delete/{code}")
    @ResponseBody
    public int delete(@PathVariable String code) {
        int rowcount = jdbcTemplate.update("DELETE FROM APP.DISCOUNT_CODE WHERE DISCOUNT_CODE=?", code);
        return rowcount;
    }
    
}
