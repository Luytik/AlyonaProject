package com.rahuj.rahuj.models;


import java.util.List;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String email;
    private String password;

    public Client(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "client")
    private List<Expenditure> expenditureList;

    @OneToMany(mappedBy = "client")
    private List<Revenue> revenueList;

    @ManyToMany
    private Set<Role> roles;    
}
