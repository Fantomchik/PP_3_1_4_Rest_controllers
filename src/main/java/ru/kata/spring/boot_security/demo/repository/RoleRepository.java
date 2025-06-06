package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entityes.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoles(String roles);
}
