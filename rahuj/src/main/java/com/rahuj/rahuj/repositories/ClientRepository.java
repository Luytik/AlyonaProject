package com.rahuj.rahuj.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rahuj.rahuj.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByEmail(String email);
    Client findByLogin(String login);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    boolean findIsLogginedInByLogin(String login);

    @Transactional
    @Modifying
    @Query("UPDATE Client e SET e.isLogginedIn = :isLogginedIn WHERE e.login = :login")
    void updateIsLogginedByUsername(@Param("login") String username, @Param("isLogginedIn") boolean isLogginedIn);
}
