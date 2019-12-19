package com.web.mvc.repository;

import com.web.mvc.beans.Customer;
import com.web.mvc.beans.PurchaseOrder;
import java.util.List;

public interface ECommerceDao {
    List<?> queryCustomer();
    List<Customer> queryCustomerRowList();
    List<PurchaseOrder> queryPurchaseOrderRowList(int customerId);
    List<PurchaseOrder> queryPurchaseOrderRowList();
}
