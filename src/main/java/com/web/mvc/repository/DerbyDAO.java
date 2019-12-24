package com.web.mvc.repository;

import java.util.List;

public interface DerbyDAO {
    List<?> queryPU_VIEW();
    List<?> getPU_TOTAL();
    List<?> queryPU_TOP10();
}
