package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Studyweek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudyweekRepository extends JpaRepository<Studyweek, Long> {
}