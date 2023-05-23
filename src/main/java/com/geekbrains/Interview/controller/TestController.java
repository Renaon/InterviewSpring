package com.geekbrains.Interview.controller;

import com.geekbrains.Interview.controller.intetface.StandardController;
import com.geekbrains.Interview.dto.CommonDTO;
import com.geekbrains.Interview.dto.StudentDTO;
import com.geekbrains.Interview.entity.Student;
import com.geekbrains.Interview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class TestController implements StandardController {
    @Autowired
    StudentService studentService;

    @GetMapping("/init")
    public List<StudentDTO> initStudent() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++){
            int mark = random.nextInt(10 - 1 + 1) + 1;
            Student student = new Student();
            student.setName(Integer.toString(i));
            student.setMark(mark);
            studentService.add(student);
        }
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<Student> students = studentService.getAll();
        for (Student student: students) {
            studentDTOs.add(new StudentDTO(student.getId(),student.getName(),student.getMark()));
        }
        return studentDTOs;
    }

    @GetMapping("delete")
    public String delete(@RequestParam("name") String name) {
        Long id = studentService.loadStudentByName(name).getId();
        studentService.delete(id);
        return "success";
    }

    @PostMapping("create")
    public String create(@RequestParam("name") String name, @RequestParam("mark") String mark){
        Student student = new Student();
        student.setName(name);
        student.setMark(Integer.valueOf(mark));
        studentService.add(student);
        return "/";
    }

    @PostMapping("/change_mark")
    public StudentDTO change_mark(@RequestParam("name") String name, @RequestParam("mark") Integer mark){
        studentService.changeMark(name, mark);
        Student student = studentService.loadStudentByName(name);
        return new StudentDTO(student.getId(), student.getName(),student.getMark());
    }

    @GetMapping("add")
    public String add(){
        return "add";
    }

    public List<StudentDTO> getAll(){
        List<Student> students = studentService.getAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student: students) {
            studentDTOList.add(new StudentDTO(student.getId(), student.getName(),student.getMark()));
        }
        return studentDTOList;
    }

    @GetMapping("/")
    public String index(Model model){
        List<StudentDTO> students = getAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("get_student")
    public StudentDTO getStudent(@RequestParam("name") String name){
        Student student = studentService.loadStudentByName(name);
        return new StudentDTO(student.getId(), student.getName(), student.getMark());
    }
}
