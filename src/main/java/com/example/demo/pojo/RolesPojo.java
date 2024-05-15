package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolesPojo {
    private Integer id;

    @NotNull(message = "Post is a required field")
    private String post;
}