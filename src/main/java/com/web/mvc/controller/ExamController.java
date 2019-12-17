package com.web.mvc.controller;

import com.web.mvc.beans.Exam;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
    static List<Exam> exams = new CopyOnWriteArrayList<>();
    
    @RequestMapping("/input")
    public String input(Model model) {
        model.addAttribute("exam", new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
        return "exam";
    }
    
    @RequestMapping("/add")
    public String add(Exam exam, Model model) {
        exams.add(exam);
        model.addAttribute("exam", new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
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
        model.addAttribute("exam", new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
        return "exam";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        exams.removeIf(e -> e.getId().equals(id));
        model.addAttribute("exam", new Exam());
        model.addAttribute("exams", exams);
        model.addAttribute("action", "add");
        return "exam";
    }
}
