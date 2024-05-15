package com.example.demo.service.impl;
import com.example.demo.entity2.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> getAllRoles();

    Roles getRolesById(Long id);

    Roles createRoles(Roles roles);

    Roles updateRoles(Long id, Roles roles);

    boolean deleteRoles(Long id);
}




