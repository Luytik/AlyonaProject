package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Expenditure;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
    
}
