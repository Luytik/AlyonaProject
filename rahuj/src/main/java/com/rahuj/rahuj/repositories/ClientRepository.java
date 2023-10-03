package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rahuj.rahuj.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByEmail(String email);
    Client findByLogin(String login);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
}
