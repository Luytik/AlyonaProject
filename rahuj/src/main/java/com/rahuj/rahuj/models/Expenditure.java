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
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "when")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ExpenditureCategory_id")
    private ExpenditureCategory expenditureCategory;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;

    private Double value;
    private String description;
    public Expenditure(Date date, ExpenditureCategory expenditureCategory, Client client, Double value,
            String description) {
        this.date = date;
        this.expenditureCategory = expenditureCategory;
        this.client = client;
        this.value = value;
        this.description = description;
    }

    
}
