package com.web.mvc.controller;

import com.web.mvc.beans.Student;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

    static List<Student> students;

    static {
        students = new CopyOnWriteArrayList<>();
        students.add(new Student("Vincent", "boy"));
        students.add(new Student("Anita", "girl"));
    }

    @RequestMapping(value = "/input")
    public String input(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("action", "add");
        return "student";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Student student, Model model) {
        students.add(student);
        model.addAttribute("students", students);
        return "student_list";
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String get(@PathVariable("name") String name, Model model) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getName().equals(name))
                .findAny();
        model.addAttribute("student", student.isPresent() ? student.get() : new Student());
        model.addAttribute("action", "update");
        return "student";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Student student, Model model) {
        students.stream()
                .filter(s -> s.getName().equals(student.getName()))
                .forEach(s -> {
                    s.setSex(student.getSex());
                });
        model.addAttribute("students", students);
        return "student_list";
    }
}
