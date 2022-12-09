package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TermID;
    private String TermName;
    private Timestamp StartTimeSignSubject;
    private Timestamp EndTimeSignSubject;
    private Timestamp StartTimeSignCredit;
    private Timestamp EndTimeSignCredit;
    private int TermNumber;
    @JsonBackReference
    @OneToMany(mappedBy = "Term", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SignSubject> SignSubject;
    @JsonBackReference
    @OneToMany(mappedBy = "Term", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classsection> Classsection;

}
