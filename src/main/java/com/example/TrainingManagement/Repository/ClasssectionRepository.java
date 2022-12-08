package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Classsection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClasssectionRepository extends JpaRepository<Classsection, Long> {
}
