package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

public class Groupx {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long GroupID;
    private String GroupName;
    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "Groupx", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<AccountGroup> AccountGroup;
}
