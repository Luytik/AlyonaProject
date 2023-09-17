package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahuj.rahuj.models.RevenueCategory;

@Repository
public interface RevenueCategoryRepository extends JpaRepository<RevenueCategory, Long>{
    
}
