package com.web.mvc.controller;

import com.web.mvc.beans.Exam;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
