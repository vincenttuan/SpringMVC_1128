package com.web.mvc.validator;

import com.web.mvc.beans.Exam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ExamValidator implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Exam.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Exam exam = (Exam)object;
        ValidationUtils.rejectIfEmpty(errors, "id", "exam.id.required");
        
    }
    
}
