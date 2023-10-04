package com.rahuj.rahuj.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long>{
    List<Revenue> findAllByClientId(Long id);
}
