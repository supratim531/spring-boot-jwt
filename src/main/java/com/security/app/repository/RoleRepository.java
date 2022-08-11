package com.security.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
