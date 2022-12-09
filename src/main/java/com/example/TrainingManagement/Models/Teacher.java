package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account Account;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classsection> Classsection;
}
