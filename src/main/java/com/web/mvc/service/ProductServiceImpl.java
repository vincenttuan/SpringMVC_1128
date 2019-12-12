package com.web.mvc.service;

import com.web.mvc.beans.Group;
import com.web.mvc.beans.Product;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    // 設定 商品分類資料

    public ProductServiceImpl() {
        if (groups.size() == 0) {
            groups.put(1, new Group(1, "A"));
            groups.put(2, new Group(2, "B"));
            groups.put(3, new Group(3, "C"));
        }
    }

    @Override
    public boolean save(Product product) {
        product.setGroup(getGroup(product));
        products.add(product);
        return true;
    }

    @Override
    public Product get(String name) {
        Product product = products.stream()
                .filter(p -> p.getName().equals(name))
                .findAny().get();
        return product == null ? new Product() : product;
    }

    @Override
    public List<Product> query() {
        return products;
    }

    @Override
    public boolean update(Product product) {
        products.stream()
                .filter(p -> p.getName().equals(product.getName()))
                .forEach(p -> {
                    p.setGroup(getGroup(product));
                    p.setAmount(product.getAmount());
                    p.setPrice(product.getPrice());
                    p.setDate(product.getDate());
                });
        return true;
    }

    @Override
    public boolean delete(String name) {
        return products.removeIf(p -> p.getName().equals(name));
    }

    private Group getGroup(Product product) {
        Integer gid = product.getGroup().getGid();
        return groups.get(gid);
    }
    
}
