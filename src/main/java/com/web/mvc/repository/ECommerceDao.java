package com.web.mvc.repository;

import com.web.mvc.beans.Customer;
import java.util.List;

public interface ECommerceDao {
    List<?> queryCustomer();
    List<Customer> queryCustomerRowList();
}
