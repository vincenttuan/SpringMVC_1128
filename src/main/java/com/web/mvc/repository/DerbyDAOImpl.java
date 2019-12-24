package com.web.mvc.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "derbyDao")
public class DerbyDAOImpl implements DerbyDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<?> queryPU_VIEW() {
        String sql = "SELECT * FROM APP.PU_VIEW";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<?> getPU_TOTAL() {
        String sql = "SELECT * FROM APP.PU_TOTAL";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<?> queryPU_TOP10() {
        String sql = "SELECT * FROM APP.PU_TOP10";
        return jdbcTemplate.queryForList(sql);
    }
    
}
