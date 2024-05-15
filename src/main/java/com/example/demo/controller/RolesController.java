package com.example.demo.controller;

import com.example.demo.entity2.Roles;
import com.example.demo.pojo.RolesPojo;
import com.example.demo.service.impl.RolesService;
import com.example.demo.shared.pojo.GlobalApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public GlobalApiResponse<List<Roles>> getAllRoles() {
        return GlobalApiResponse
                .<List<Roles>>builder()
                .data(rolesService.getAllRoles())
                .statusCode(200)
                .message("Data retrieved successfully")
                .build();
    }

    @PostMapping
    public GlobalApiResponse<String> saveRole(@RequestBody @Valid RolesPojo rolesPojo) {
        Roles role = new Roles();
        role.setPost(rolesPojo.getPost());
        rolesService.createRole(role);
        return GlobalApiResponse
                .<String>builder()
                .data("saved")
                .statusCode(200)
                .message("Data saved successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateRole(@PathVariable Integer id, @RequestBody RolesPojo rolesPojo) {
        Roles role = new Roles();
        role.setId(id);
        role.setPost(rolesPojo.getPost());
        rolesService.updateRole(id, role);
        return GlobalApiResponse
                .<String>builder()
                .data("updated")
                .statusCode(200)
                .message("Data updated successfully")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<Roles> getRoleById(@PathVariable Integer id) {
        Roles role = rolesService.getRoleById(id);
        return GlobalApiResponse
                .<Roles>builder()
                .data(role)
                .statusCode(200)
                .message("Data retrieved successfully")
                .build();
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteRole(@PathVariable Integer id) {
        rolesService.deleteRole(id);
        return GlobalApiResponse
                .<String>builder()
                .data("deleted")
                .statusCode(200)
                .message("Data deleted successfully")
                .build();
    }
}