package com.ktmbees.securityLearn.dto;

import com.ktmbees.securityLearn.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRequest {
    private Student student;
}
