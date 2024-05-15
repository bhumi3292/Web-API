package com.example.demo.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ground")
public class Ground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ground_name;

    public void setName(String ground_name) {
    }

    public void setId(Integer id) {
    }

    public void setGround_name(String groundName) {
        this.ground_name = ground_name;
    }

    public String getGround_name() {
        return ground_name;
    }
}