package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MajorID;
    private String MajorName;
    private String MajorCode;
    @JsonBackReference
    @OneToMany(mappedBy = "Major", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<SubjectMajor> SubjectMajor;
}
