package com.web.mvc.service;

import com.web.mvc.beans.PurchaseOrder;
import java.util.List;

public interface ECommerceService {
    List<?> queryCustomer();
    List<?> queryPurchaseOrder(int customerId);
}
