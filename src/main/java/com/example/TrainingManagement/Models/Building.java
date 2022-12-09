package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Classroom> Classroom;
}
