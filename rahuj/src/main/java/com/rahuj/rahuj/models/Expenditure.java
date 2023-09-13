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
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ExpenditureCategory_id")
    private ExpenditureCategory expenditureCategory;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Client user;

    private Double value;
    private String description;
    public Expenditure(Date date, ExpenditureCategory expenditureCategory, Client user, Double value,
            String description) {
        this.date = date;
        this.expenditureCategory = expenditureCategory;
        this.user = user;
        this.value = value;
        this.description = description;
    }

    
}
