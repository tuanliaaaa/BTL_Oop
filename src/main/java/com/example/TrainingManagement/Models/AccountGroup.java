package com.example.TrainingManagement.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccountGroupID;

    @ManyToOne
    @JoinColumn(name = "AccountID", nullable = false)
    private Account Account;

    @ManyToOne
    @JoinColumn(name = "GroupxID", nullable = false)
    private Groupx Groupx;
}
