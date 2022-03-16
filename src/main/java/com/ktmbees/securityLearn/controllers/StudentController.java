package com.ktmbees.securityLearn.controllers;

import com.ktmbees.securityLearn.dto.StudentRequest;
import com.ktmbees.securityLearn.models.Student;
import com.ktmbees.securityLearn.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/saveInfo")
    public Student saveInfo(@RequestBody StudentRequest request){
        return studentRepository.save(request.getStudent());
    }
    @GetMapping("/viewStudents")
    public List<Student> viewStudents(){
        return studentRepository.findAll();
    }

    List<Student> results = new ArrayList<Student>();
    @GetMapping(path="/{student_id}")
    public Student getStudent(@PathVariable("student_id") Integer student_id){
        Optional<Student> studentResponse = studentRepository.findById(student_id);
        Student student = studentResponse.get();
        return student;
    }

}
