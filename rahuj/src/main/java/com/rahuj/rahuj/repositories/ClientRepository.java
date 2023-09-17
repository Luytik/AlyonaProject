package com.rahuj.rahuj.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahuj.rahuj.models.Client;

@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);    
}
