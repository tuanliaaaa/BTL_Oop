package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long StudentID;
    private String StudentName;
    private String StudentCode;
    @OneToOne
    @JoinColumn(name = "AccountId")
    private Account Account;
    @JsonBackReference
    @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SignSubject> SignSubject;
    @JsonBackReference
    @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<ClasssectionStudent> ClasssectionStudent;
}
