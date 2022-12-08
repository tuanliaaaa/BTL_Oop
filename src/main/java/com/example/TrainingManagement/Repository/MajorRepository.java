package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
}