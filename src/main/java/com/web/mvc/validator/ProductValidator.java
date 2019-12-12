package com.web.mvc.validator;

import com.web.mvc.beans.Product;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Product.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Product product = (Product)object;
        ValidationUtils.rejectIfEmpty(errors, "name", "product.name.required");
        
        if(product.getPrice() < 10 || product.getPrice() > 100) {
            errors.rejectValue("price", "product.price.invalid");
        }
        
        if(product.getAmount() <= 0) {
            errors.rejectValue("amount", "product.amount.invalid");
        }
        
        if(product.getDate() == null || product.getDate().after(new Date()) ) {
            errors.rejectValue("date", "date.invalid");
        }
    }
    
}
