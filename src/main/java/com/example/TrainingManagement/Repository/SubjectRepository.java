package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}