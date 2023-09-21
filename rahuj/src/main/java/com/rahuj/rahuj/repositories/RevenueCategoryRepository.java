package com.rahuj.rahuj.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.RevenueCategory;

public interface RevenueCategoryRepository extends JpaRepository<RevenueCategory, Long>{
    boolean existsByRevenueCategory(String category);
    Optional<RevenueCategory> findByRevenueCategory(String category);    
}
