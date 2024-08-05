package com.example.studentassement.service.impl;

import com.example.studentassement.dto.StudentDto;
import com.example.studentassement.dto.SubjectDto;
import com.example.studentassement.entity.Student;
import com.example.studentassement.entity.Subject;
import com.example.studentassement.repository.StudentRepository;
import com.example.studentassement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setUsername(student.getUsername());
                    studentDto.setAddress(student.getAddress());
                    studentDto.setSubjects(student.getSubjects().stream()
                            .map(subject -> new SubjectDto(subject.getName()))
                            .collect(Collectors.toList()));
                    return studentDto;
                })
                .collect(Collectors.toList());
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setUsername(studentDto.getUsername());
        student.setAddress(studentDto.getAddress());
        student.setSubjects(studentDto.getSubjects().stream()
                .map(subjectDto -> {
                    Subject subject = new Subject();
                    subject.setName(subjectDto.getName());
                    return subject;
                })
                .collect(Collectors.toSet()));
        studentRepository.save(student);
        return studentDto;
    }

    public StudentDto getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            StudentDto studentDto = new StudentDto();
            studentDto.setUsername(student.getUsername());
            studentDto.setAddress(student.getAddress());
            studentDto.setSubjects(student.getSubjects().stream()
                    .map(subject -> new SubjectDto(subject.getName()))
                    .collect(Collectors.toList()));
            return studentDto;
        } else
            return null;
    }
}
