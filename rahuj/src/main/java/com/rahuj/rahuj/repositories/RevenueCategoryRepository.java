package com.rahuj.rahuj.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.RevenueCategory;

public interface RevenueCategoryRepository extends JpaRepository<RevenueCategory, Long>{
    boolean existsByRevenueCategory(String category);
    Optional<RevenueCategory> findByRevenueCategory(String category);
    List<RevenueCategory> findAllByClient(Client client);  
}
