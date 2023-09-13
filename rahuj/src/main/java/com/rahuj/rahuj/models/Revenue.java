package com.rahuj.rahuj.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "RevenueCategory_id")
    private RevenueCategory revenueCategory;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Client user;

    private Double value;
    private String description;
    public Revenue(Date date, RevenueCategory revenueCategory, Client user, Double value, String description) {
        this.date = date;
        this.revenueCategory = revenueCategory;
        this.user = user;
        this.value = value;
        this.description = description;
    }

    
}
