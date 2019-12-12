package com.web.mvc.service;

import com.web.mvc.beans.Group;
import com.web.mvc.beans.Product;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ProductService {
    // 商品分類
    Map<Integer, Group> groups = new LinkedHashMap<>();
    // 資料表
    List<Product> products = new ArrayList<>();
    // 新增商品
    boolean save(Product product);
    // 取得商品單筆
    Product get(String name);
    // 查詢商品多筆
    List<Product> query();
    // 修改商品
    boolean update(Product product);
    // 刪除商品
    boolean delete(String name);
}
