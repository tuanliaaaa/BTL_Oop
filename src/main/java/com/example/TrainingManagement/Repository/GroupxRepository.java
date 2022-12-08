package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.Groupx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupxRepository extends JpaRepository<Groupx, Long> {
}

