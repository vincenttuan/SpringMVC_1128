package com.web.mvc.beans;

public class BMI {
    private Double h;
    private Double w;
    private Double bmi;

    public BMI(Double h, Double w) {
        this.h = h;
        this.w = w;
        bmi = w / Math.pow(h/100, 2);
    }

    public Double getH() {
        return h;
    }

    public Double getW() {
        return w;
    }

    public Double getBmi() {
        return bmi;
    }
    
    
}
