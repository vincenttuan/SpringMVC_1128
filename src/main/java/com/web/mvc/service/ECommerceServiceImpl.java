package com.web.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.web.mvc.repository.ECommerceDao;

@Service
public class ECommerceServiceImpl implements ECommerceService {
    @Autowired
    @Qualifier(value = "ecDao")
    private ECommerceDao dao;

    @Override
    public List<?> queryCustomer() {
        return dao.queryCustomerRowList();
    }

    @Override
    public List<?> queryPurchaseOrder(int customerId) {
        return dao.queryPurchaseOrderRowList(customerId);
    }
    
    @Override
    public List<?> queryPurchaseOrder() {
        return dao.queryPurchaseOrderRowList();
    }
}
