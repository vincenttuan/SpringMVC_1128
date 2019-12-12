package com.web.mvc.beans;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {

    private Group group; // 商品分類
    private String name; // 商品名稱
    private double price; // 價格
    private int amount; // 數量
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date = new Date(); // 上架日期不可以大於今日

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
