package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TeacherID;
    private String TeacherName;
    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account Account;
    @JsonBackReference
    @OneToMany(mappedBy = "Teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classsection> Classsection;
}
