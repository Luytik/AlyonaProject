package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahuj.rahuj.models.ExpenditureCategory;

@Repository
public interface ExpenditureCategoryRepository extends JpaRepository<ExpenditureCategory, Long>{
    
}
