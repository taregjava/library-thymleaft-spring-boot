package com.booklibrary.booklibrary.repository;

import com.booklibrary.booklibrary.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
