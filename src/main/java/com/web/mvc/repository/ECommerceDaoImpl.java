package com.web.mvc.repository;

import com.web.mvc.beans.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "ecDao")
public class ECommerceDaoImpl implements ECommerceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<?> queryCustomer() {
        String sql = "SELECT * FROM APP.CUSTOMER";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Customer> queryCustomerRowList() {
        String sql = "SELECT * FROM APP.CUSTOMER";
        RowMapper rm = (ResultSet rs, int i) -> {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
            customer.setDiscountCode(rs.getString("DISCOUNT_CODE"));
            customer.setZip(rs.getString("ZIP"));
            customer.setName(rs.getString("NAME"));
            customer.setAddressLine1(rs.getString("ADDRESSLINE1"));
            customer.setAddressLine2(rs.getString("ADDRESSLINE2"));
            customer.setCity(rs.getString("CITY"));
            customer.setState(rs.getString("STATE"));
            customer.setPhone(rs.getString("PHONE"));
            customer.setFax(rs.getString("FAX"));
            customer.setEmail(rs.getString("EMAIL"));
            customer.setCreditLimit(rs.getInt("CREDIT_LIMIT"));
            return customer;
        };
        return jdbcTemplate.query(sql, rm);
    }
    
    
}
