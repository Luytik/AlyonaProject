package com.rahuj.rahuj.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class RevenueCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String revenueCategory;

    @OneToMany(mappedBy = "revenueCategory")
    private Set<Revenue> revenueList;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public RevenueCategory(String category){
        revenueCategory = category;
    }
}
