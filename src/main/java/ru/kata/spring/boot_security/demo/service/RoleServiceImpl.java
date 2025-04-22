package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entityes.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByName(String name) {
        return roleRepository.findByRoles(name);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
