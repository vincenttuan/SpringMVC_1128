package com.web.mvc.controller;

import com.web.mvc.beans.Exam;
import com.web.mvc.validator.ExamValidator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
    
    static List<Exam> exams = new CopyOnWriteArrayList<>();
    
    @Autowired
    private ExamValidator examValidator;
    
    @RequestMapping("/input")
    public String input(Model model) {
        model.addAttribute("exam", new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
        model.addAttribute("stat", stat());
        model.addAttribute("stat2", stat2());
        return "exam";
    }
    
    @RequestMapping("/add")
    public String add(Exam exam, BindingResult result, Model model) {
        this.examValidator.validate(exam, result);
        if(!result.hasErrors()) {
            exams.add(exam);
            return "redirect:/mvc/exam/input";
        }
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
        model.addAttribute("stat", stat());
        model.addAttribute("stat2", stat2());
        return "exam";
    }
    
    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        Optional<Exam> exam = exams.stream()
                .filter(e -> e.getId().equals(id))
                .findAny();
        model.addAttribute("exam", exam.isPresent() ? exam.get() : new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        model.addAttribute("stat", stat());
        model.addAttribute("stat2", stat2());
        return "exam";
    }
    
    @RequestMapping("/update")
    public String update(Exam exam, Model model) {
        String id = exam.getId();
        Exam oExam = exams.stream().filter(e -> e.getId().equals(id)).findAny().get();
        if(oExam != null) {
            oExam.setExam(exam.getExam());
            oExam.setNote(exam.getNote());
            oExam.setPay(exam.getPay());
            oExam.setSlot(exam.getSlot());
        }
        return "redirect:/mvc/exam/input";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        exams.removeIf(e -> e.getId().equals(id));
        return "redirect:/mvc/exam/input";
    }
    
    public Map<String, Long> stat() {
        Map<String, Long> stat = exams.stream().collect(groupingBy(Exam::getExam, counting()));
        return stat;
    }
    
    public Map<String, Long> stat2() {
        Map<String, Long> stat2 = exams.stream().collect(groupingBy(Exam::getPay, counting()));
        return stat2;
    }
    
}
