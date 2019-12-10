package com.web.mvc.controller;

import com.web.mvc.beans.Student;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Student student, Model model) {
        students.add(student);
        model.addAttribute("students", students);
        return "student_list";
    }
    
    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable("name") String name, Model model) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getName().equals(name))
                .findAny();
        return student.isPresent()?student.get().toString():new Student().toString();
    }
}
