package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
}