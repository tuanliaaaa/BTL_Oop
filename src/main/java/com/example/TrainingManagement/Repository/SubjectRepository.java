package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
//    List<Subject> findBySubjectMajor_SubjectMajorID(int SubjectMajorID);

}