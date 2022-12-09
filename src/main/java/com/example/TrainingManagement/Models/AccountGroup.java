package com.example.TrainingManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccountGroupID;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "AccountID", nullable = false)
    private Account Account;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "GroupxID", nullable = false)
    private Groupx Groupx;
}
