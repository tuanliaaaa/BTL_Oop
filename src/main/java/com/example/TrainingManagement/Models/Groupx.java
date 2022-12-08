package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table( schema = "okes")
public class Groupx {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GroupID;
    private String GroupName;
    @JsonBackReference
    @OneToMany(mappedBy = "Groupx", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<AccountGroup> AccountGroup;
}
