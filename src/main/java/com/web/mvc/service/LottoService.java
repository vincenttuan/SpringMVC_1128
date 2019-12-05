package com.web.mvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LottoService {
    Map<Integer, Set<Integer>> lotto539(Integer count);
    Map<Integer, List<Integer>> lotto4Star(Integer count);
    Map<Integer, List<Integer>> lotto3Star(Integer count);
}
