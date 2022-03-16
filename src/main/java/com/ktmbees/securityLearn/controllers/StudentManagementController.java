package com.ktmbees.securityLearn.controllers;

import com.ktmbees.securityLearn.models.Student;
import com.ktmbees.securityLearn.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api")
public class StudentManagementController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        System.out.println("find all");
        return studentRepository.findAll();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("register");
        System.out.println(student);
    }

    @DeleteMapping(path = "{student_id}")
    public void deleteStudent(@PathVariable("student_id") Integer student_id){
        System.out.println("delete");
        System.out.println(student_id);
    }

    @PutMapping(path = "{student_id}")
    public void updateStudent(@PathVariable("student_id") Integer student_id,@RequestBody Student student){
        System.out.println("update student");

    }
}
