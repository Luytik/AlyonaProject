package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Expenditure;
import java.util.List;


public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
    List<Expenditure> findAllByClient(Client client);
}
