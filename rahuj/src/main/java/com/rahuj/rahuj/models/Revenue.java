package com.rahuj.rahuj.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "RevenueCategory_id", nullable = false)
    private RevenueCategory revenueCategory;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private Double money;
    private String description;
    public Revenue(Date date, RevenueCategory revenueCategory, Client client, Double money, String description) {
        this.date = date;
        this.revenueCategory = revenueCategory;
        this.client = client;
        this.money = money;
        this.description = description;
    }    
}
