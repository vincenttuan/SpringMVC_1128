package com.web.mvc.service;

import java.util.List;

public interface DerbyService {
    List<?> queryPU_VIEW();
    List<?> getPU_TOTAL();
    List<?> queryPU_TOP10();
}
