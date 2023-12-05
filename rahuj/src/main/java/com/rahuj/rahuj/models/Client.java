package com.rahuj.rahuj.models;


import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @Column(columnDefinition = "boolean default false")
    private boolean isLogginedIn;

    public Client(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "client")
    private List<Expenditure> expenditureList;

    @OneToMany(mappedBy = "client")
    private List<Revenue> revenueList;

    @OneToMany
    private List<ExpenditureCategory> expenditureCategories;

    @OneToMany
    private List<RevenueCategory> revenueCategories;

    @ManyToMany
    private Set<Role> roles;
}
