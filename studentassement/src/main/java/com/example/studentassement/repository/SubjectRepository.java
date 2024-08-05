package com.example.studentassement.repository;

import com.example.studentassement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository <Subject, Long> {

}
