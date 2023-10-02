package com.rahuj.rahuj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahuj.rahuj.models.Client;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);
    Client findByLogin(String login);
    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update Client c SET c.enable = TRUE WHERE c.email = ?1")
    int enableClient(String email);
}
