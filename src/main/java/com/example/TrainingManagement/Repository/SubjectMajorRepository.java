package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Subject;
import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectMajorRepository extends JpaRepository<SubjectMajor, Long> {
}