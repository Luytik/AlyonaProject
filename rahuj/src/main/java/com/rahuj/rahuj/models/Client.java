package com.rahuj.rahuj.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String clientname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Expenditure> expenditureList;

    @OneToMany(mappedBy = "user")
    private List<Revenue> revenueList;
    




}
