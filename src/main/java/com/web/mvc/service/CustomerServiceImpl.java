package com.web.mvc.service;

import com.web.mvc.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    @Qualifier(value = "cusDao")
    private CustomerDao dao;
}
