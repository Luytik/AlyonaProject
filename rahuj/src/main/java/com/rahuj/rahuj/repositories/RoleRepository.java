package com.rahuj.rahuj.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuj.rahuj.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}