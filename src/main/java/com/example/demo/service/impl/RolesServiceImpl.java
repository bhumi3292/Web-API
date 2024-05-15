package com.example.demo.service.impl;
import com.example.demo.entity2.Roles;
import com.example.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Long id) {
        Optional<Roles> rolesOptional = rolesRepository.findById(id);
        return rolesOptional.orElse(null);
    }

    @Override
    public Roles createRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public Roles updateRoles(Long id, Roles roles) {
        if (rolesRepository.existsById(id)) {
            Roles.setId(id);
            return rolesRepository.save(roles);
        }
        return null;
    }

    @Override
    public boolean deleteRoles(Long id) {
        if (rolesRepository.existsById(id)) {
            rolesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}