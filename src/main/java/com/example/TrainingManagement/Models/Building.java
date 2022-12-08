package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long BuildingID;
    private String BuildingName;
    @JsonBackReference
    @OneToMany(mappedBy = "Building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classroom> Classroom;
}
