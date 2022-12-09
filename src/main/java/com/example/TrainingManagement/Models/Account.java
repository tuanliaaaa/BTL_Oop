package com.example.TrainingManagement.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.util.List;

@Entity
@Data

public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long AccountID;
        private String Username;
        private String Password;
        @JsonIgnore
        @JsonBackReference
        @OneToMany(mappedBy = "Account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        Set<AccountGroup> AccountGroup;
        @JsonIgnore
        @JsonBackReference
        @OneToOne(mappedBy = "Account")
        private Teacher Teacher;
        @JsonIgnore
        @JsonBackReference
        @OneToOne(mappedBy = "Account")
        private Student Student ;

}
