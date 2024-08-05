package com.example.studentassement.service.impl;

import com.example.studentassement.dto.SubjectDto;
import com.example.studentassement.entity.Subject;
import com.example.studentassement.repository.SubjectRepository;
import com.example.studentassement.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (Subject subject : subjects) {
            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setName(subject.getName());
            subjectDtos.add(subjectDto);
        }
        return subjectDtos;
    }
}


