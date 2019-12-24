package com.web.mvc.service;

import com.web.mvc.repository.DerbyDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DerbyServiceImpl implements DerbyService {
    @Autowired
    @Qualifier(value = "derbyDao")
    private DerbyDAO dao;

    @Override
    public List<?> queryPU_VIEW() {
        return dao.queryPU_VIEW();
    }

    @Override
    public List<?> getPU_TOTAL() {
        return dao.getPU_TOTAL();
    }

    @Override
    public List<?> queryPU_TOP10() {
        return dao.queryPU_TOP10();
    }
    
}
