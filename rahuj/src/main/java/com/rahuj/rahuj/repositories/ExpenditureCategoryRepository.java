package com.rahuj.rahuj.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.ExpenditureCategory;

public interface ExpenditureCategoryRepository extends JpaRepository<ExpenditureCategory, Long>{
    boolean existsByExpenditureCategory(String category);
    Optional<ExpenditureCategory> findByExpenditureCategory(String category);
    List<ExpenditureCategory> findAllByClient(Client client);
}
