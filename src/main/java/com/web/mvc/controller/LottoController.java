package com.web.mvc.controller;

import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/lotto")
public class LottoController {
    
    @RequestMapping("/539")
    @ResponseBody
    public String lotto539(@RequestParam(name = "count", defaultValue = "1", required = false) Integer count) {
        Map<Integer, Set<Integer>> lottos = new LinkedHashMap<>();
        IntStream.rangeClosed(1, count).forEach(i -> {
            Set<Integer> lotto = new LinkedHashSet<>();
            while(lotto.size() < 5) {
                lotto.add(new Random().nextInt(39)+1);
            }
            lottos.put(i, lotto);
        });
        return new Gson().toJson(lottos);
    }
}
