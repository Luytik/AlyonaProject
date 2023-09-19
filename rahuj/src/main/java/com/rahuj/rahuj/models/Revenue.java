package com.rahuj.rahuj.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "when")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "RevenueCategory_id")
    private RevenueCategory revenueCategory;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;

    private Double value;
    private String description;
    public Revenue(Date date, RevenueCategory revenueCategory, Client client, Double value, String description) {
        this.date = date;
        this.revenueCategory = revenueCategory;
        this.client = client;
        this.value = value;
        this.description = description;
    }

    
}
