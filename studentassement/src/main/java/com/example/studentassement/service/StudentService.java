package com.example.studentassement.service;

import com.example.studentassement.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);


}
