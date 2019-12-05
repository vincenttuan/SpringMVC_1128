package com.web.mvc.service;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService {
    
    @Override
    public Map<Integer, Set<Integer>> lotto539(Integer count) {
        Map<Integer, Set<Integer>> lottos = new LinkedHashMap<>();
        IntStream.rangeClosed(1, count).forEach(i -> {
            Set<Integer> lotto = new LinkedHashSet<>();
            while(lotto.size() < 5) {
                lotto.add(new Random().nextInt(39)+1);
            }
            lottos.put(i, lotto);
        });
        return lottos;
    }

    @Override
    public Map<Integer, List<Integer>> lotto4Star(Integer count) {
        Map<Integer, List<Integer>> lottos = new LinkedHashMap<>();
        IntStream.rangeClosed(1, count).forEach(i -> {
            List<Integer> lotto = new ArrayList<>();
            while(lotto.size() < 4) {
                lotto.add(new Random().nextInt(10));
            }
            lottos.put(i, lotto);
        });
        return lottos;
    }

    @Override
    public Map<Integer, List<Integer>> lotto3Star(Integer count) {
        Map<Integer, List<Integer>> lottos = new LinkedHashMap<>();
        IntStream.rangeClosed(1, count).forEach(i -> {
            List<Integer> lotto = new ArrayList<>();
            while(lotto.size() < 3) {
                lotto.add(new Random().nextInt(10));
            }
            lottos.put(i, lotto);
        });
        return lottos;
    }
    
}
