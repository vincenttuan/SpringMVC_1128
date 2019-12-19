package com.web.mvc.service;

import java.util.List;

public interface ECommerceService {
    List<?> queryCustomer();
    List<?> queryPurchaseOrder(int customerId);
    List<?> queryPurchaseOrder();
}
