package com.ktmbees.securityLearn.controllers;

import com.ktmbees.securityLearn.models.Student;
import com.ktmbees.securityLearn.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management/api")
public class StudentManagementController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudent(){
        System.out.println("find all");
        return studentRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("register");
        System.out.println(student);
    }

    @DeleteMapping(path = "{student_id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("student_id") Integer student_id){
        System.out.println("delete");
        System.out.println(student_id);
    }

    @PutMapping(path = "{student_id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("student_id") Integer student_id,@RequestBody Student student){
        System.out.println("update student");

    }
}
