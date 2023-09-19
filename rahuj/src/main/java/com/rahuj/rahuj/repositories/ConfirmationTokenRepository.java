package com.rahuj.rahuj.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahuj.rahuj.models.ConfirmationToken;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>{
    Optional<ConfirmationToken> findbyToken(String token);
}
